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

    public Users user (UsersDto usersDto) {
//        Caesar64 caesar64 = new Caesar64();
        Vigenere64 vigenere64 = new Vigenere64();
        Users users = new Users();

        //Mendapatkan UserId terakhir dari database
        String uuid = generateShortUUID();

        //encrypt Vigenere
        String encryptUserId = vigenere64.encrypt(uuid, "aris");
        users.setUserId(encryptUserId);
        String encryptNama = vigenere64.encrypt(usersDto.getNamaLengkap(), "aris");
        users.setNamaLengkap(encryptNama);
        String encryptNamaSuami = vigenere64.encrypt(usersDto.getNamaSuami(), "aris");
        users.setNamaSuami(encryptNamaSuami);
        String encryptUmur = vigenere64.encrypt(usersDto.getUmur(), "aris");
        users.setUmur(encryptUmur);
        String encryptNoTelp = vigenere64.encrypt(usersDto.getNoTelp(), "aris");
        users.setNoTelp(encryptNoTelp);
        String encryptEmail = vigenere64.encrypt(usersDto.getEmail(), "aris");
        users.setEmail(encryptEmail);
        String encryptPass = vigenere64.encrypt(usersDto.getPassword(), "aris");
        users.setPassword(encryptPass);
        return userRepo.save(users);
    }

    private String generateShortUUID() {
        String uuid = UUID.randomUUID().toString();
        return uuid.substring(0, 7);
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
