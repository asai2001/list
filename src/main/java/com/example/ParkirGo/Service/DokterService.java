package com.example.ParkirGo.Service;

import com.example.ParkirGo.Dto.DokterDto;
import com.example.ParkirGo.Entity.Dokter;
import com.example.ParkirGo.Repository.DokterRepo;
import com.example.ParkirGo.encryption.Vigenere64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DokterService {

    @Autowired
    DokterRepo dokterRepo;



    public Dokter saveDokter (DokterDto dokterDto) {
        Dokter dokter = new Dokter();
        Vigenere64 vigenere64 = new Vigenere64();

        String uuid = generateShortUUID();

        final String key = "aris";

        String encryptDokterId = vigenere64.encrypt(key, uuid);
        dokter.setDokterId(encryptDokterId);
        String encryptNama = vigenere64.encrypt(dokterDto.getNamaLengkap(), key);
        dokter.setNamaLengkap(encryptNama);
        String encryptNoTelp = vigenere64.encrypt(dokterDto.getNoTelp(), key);
        dokter.setNoTelp(encryptNoTelp);
        String encryptEmail = vigenere64.encrypt(dokterDto.getEmail(), key);
        dokter.setEmail(encryptEmail);
        String plainPassword = dokterDto.getPassword();
        String hashedPassword = encodePassword(plainPassword);
        dokter.setPassword(hashedPassword);
        return dokterRepo.save(dokter);

    }


    private String generateShortUUID() {
        String uuid = UUID.randomUUID().toString();
        return uuid.substring(0, 7);
    }

    private static String encodePassword(String plainPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(plainPassword);
    }

}
