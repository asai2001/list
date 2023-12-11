package com.example.ParkirGo.Service;

import com.example.ParkirGo.Dto.UsersDto;
import com.example.ParkirGo.Entity.Users;
import com.example.ParkirGo.Repository.UserRepo;
import com.example.ParkirGo.encryption.Caesar64;
import com.example.ParkirGo.encryption.Vigenere64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

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
        String encryptEmail = vigenere64.encrypt(usersDto.getEmail(), key);
        users.setEmail(encryptEmail);
        String encryptPass = vigenere64.encrypt(usersDto.getPassword(), key);
        users.setPassword(encryptPass);
        return userRepo.save(users);
    }

    private String generateShortUUID() {
        String uuid = UUID.randomUUID().toString();
        return uuid.substring(0, 7);
    }

    private boolean isUserAlreadyRegistered(String email) {
        return userRepo.existsByEmail(email);
    }

    public Users user_update (UsersDto usersDto, String user_id) {
        Users userUpdate = userRepo.findByUserId(user_id);
        userUpdate.setNamaLengkap(usersDto.getNamaLengkap());
        userUpdate.setNamaSuami(usersDto.getNamaSuami());
        userUpdate.setUmur(usersDto.getUmur());
        userUpdate.setNoTelp(usersDto.getNoTelp());
        userUpdate.setPassword(usersDto.getPassword());
        return userRepo.save(userUpdate);
    }

}
