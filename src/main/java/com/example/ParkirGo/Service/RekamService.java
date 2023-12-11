package com.example.ParkirGo.Service;

import com.example.ParkirGo.Dto.RekamMedisDto;
import com.example.ParkirGo.Entity.RekamMedis;
import com.example.ParkirGo.Entity.Users;
import com.example.ParkirGo.Repository.RekamRepo;
import com.example.ParkirGo.Repository.UserRepo;
import com.example.ParkirGo.encryption.Vigenere64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RekamService {
    @Autowired
    RekamRepo rekamRepo;

    @Autowired
    UserRepo userRepo;

    public RekamMedis rekamMedis(RekamMedisDto rekamMedisDto){
        RekamMedis rekamMedis = new RekamMedis();
        Vigenere64 vigenere64 = new Vigenere64();

        final String key = "aris";

        String uuid = generateShortUUID();

        Users users = userRepo.findByUserId(rekamMedisDto.getUsers().getUserId());

        String encryptRekamId = vigenere64.encrypt(uuid, key);
        rekamMedis.setRekamId(encryptRekamId);
        String encryptDiagnosa = vigenere64.encrypt(rekamMedisDto.getDiagnosa(), key);
        rekamMedis.setDiagnosa(encryptDiagnosa);
        rekamMedis.setUsers(users);
        return rekamRepo.save(rekamMedis);
    }


    private String generateShortUUID() {
        String uuid = UUID.randomUUID().toString();
        return uuid.substring(0, 7);
    }

}
