package com.example.ParkirGo.Service;

import com.example.ParkirGo.Dto.UsersDto;
import com.example.ParkirGo.Entity.Users;
import com.example.ParkirGo.Repository.UserRepo;
import com.example.ParkirGo.encryption.Caesar64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public Users user (UsersDto usersDto) {
        Caesar64 caesar64 = new Caesar64();
        Users users = new Users();
        //enc
        String encryptNama = caesar64.encryptCaesarCipher(usersDto.getNamaLengkap(), 3);
        users.setNamaLengkap(encryptNama);
        users.setNamaSuami(usersDto.getNamaSuami());
        users.setUmur(usersDto.getUmur());
        users.setNoTelp(usersDto.getNoTelp());
        users.setEmail(usersDto.getEmail());
        users.setPassword(usersDto.getPassword());
        return userRepo.save(users);
    }

    public Users user_update (UsersDto usersDto, int user_id) {
        Users userUpdate = userRepo.findByUserId(user_id);
        userUpdate.setNamaLengkap(usersDto.getNamaLengkap());
        userUpdate.setNamaSuami(usersDto.getNamaSuami());
        userUpdate.setUmur(usersDto.getUmur());
        userUpdate.setNoTelp(usersDto.getNoTelp());
        userUpdate.setPassword(usersDto.getPassword());
        return userRepo.save(userUpdate);
    }

}
