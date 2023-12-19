package com.example.ParkirGo.Service;

import com.example.ParkirGo.Dto.AdminDto;
import com.example.ParkirGo.Entity.Admin;
import com.example.ParkirGo.Repository.AdminRepo;
import com.example.ParkirGo.encryption.Vigenere64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AdminService {
    @Autowired
    AdminRepo adminRepo;

    public Admin admin (AdminDto adminDto){
        Admin admin = new Admin();
        Vigenere64 vigenere64 = new Vigenere64();

        final String key = "aris";
        String uuid = generateShortUUID();

        String encrypAdminId = vigenere64.encrypt(uuid, key);
        admin.setAdminId(encrypAdminId);

        String encryptNama = vigenere64.encrypt(adminDto.getNama(), key);
        admin.setNama(encryptNama);

        String encryptNoHp = vigenere64.encrypt(adminDto.getNoHp(), key);
        admin.setNoHp(encryptNoHp);

        String encryptAlamat = vigenere64.encrypt(adminDto.getAlamat(), key);
        admin.setAlamat(encryptAlamat);

        admin.setRole("ADMIN");

        String encryptEmail = vigenere64.encrypt(adminDto.getEmail(), key);
        admin.setEmail(encryptEmail);

        String plainPassword = adminDto.getPassword();
        String hashPassword = encodePassword(plainPassword);
        admin.setPassword(hashPassword);
        return adminRepo.save(admin);
    }

    //UUID buat pengacakan ID
    private String generateShortUUID() {
        String uuid = UUID.randomUUID().toString();
        return uuid.substring(0, 7);
    }

    private static String encodePassword(String plainPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(plainPassword);
    }
}
