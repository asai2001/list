package com.example.ParkirGo.Service.Impl;


import com.example.ParkirGo.Dto.UsersDto;
import com.example.ParkirGo.Entity.Users;
import com.example.ParkirGo.Repository.UserRepo;
import com.example.ParkirGo.encryption.Vigenere64;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.UUID;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

@Service
@RequiredArgsConstructor
public class UserLoginServiceImpl implements UserImplService {

    @Autowired
    private UserRepo userRepo;



    @Override
    public Users findByEmail(String email) {
        return userRepo.findByEmail(email);
    }



    public Users registUser (UsersDto usersDto) {
        if (isUserAlreadyRegistered(usersDto.getEmail())) {
            throw new RuntimeException("Pengguna dengan email tersebut sudah digunakan");
        }

        Vigenere64 vigenere64 = new Vigenere64();
        Users users = new Users();

        final String key = "aris";

        //Mendapatkan UserId terakhir dari database
        String uuid = generateShortUUID();

        //encrypt Vigenere
        String encryptUserId = vigenere64.encrypt(uuid, key);
        users.setUserId(encryptUserId);
        String encryptNama = vigenere64.encrypt(usersDto.getNamaLengkap(), key);
        users.setNamaLengkap(encryptNama);
        String encryptNamaSuami = vigenere64.encrypt(usersDto.getNamaSuami(), key);
        users.setNamaSuami(encryptNamaSuami);
        String encryptUmur = vigenere64.encrypt(usersDto.getUmur(), key);
        users.setUmur(encryptUmur);
        String encryptNoTelp = vigenere64.encrypt(usersDto.getNoTelp(), key);
        users.setNoTelp(encryptNoTelp);
        users.setRole("USER");
        String encryptEmail = vigenere64.encrypt(usersDto.getEmail(), key);
        users.setEmail(encryptEmail);
        String plainPassword = usersDto.getPassword();
        String hashPassword = encodePassword(plainPassword);
        users.setPassword(hashPassword);
        return userRepo.save(users);
    }

    private String generateShortUUID() {
        String uuid = UUID.randomUUID().toString();
        return uuid.substring(0, 7);
    }

    private boolean isUserAlreadyRegistered(String email) {
        return userRepo.existsByEmail(email);
    }

    private static String encodePassword(String plainPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(plainPassword);
    }


}
