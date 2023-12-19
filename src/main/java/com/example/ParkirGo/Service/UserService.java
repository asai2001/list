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
