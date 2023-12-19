package com.example.ParkirGo.Service;

import com.example.ParkirGo.Dto.HadirDto;
import com.example.ParkirGo.Entity.Kehadiran;
import com.example.ParkirGo.Entity.StatusKehadiran;
import com.example.ParkirGo.Entity.Users;
import com.example.ParkirGo.Repository.HadirRepo;
import com.example.ParkirGo.Repository.UserRepo;
import com.example.ParkirGo.encryption.Vigenere64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class KehadiranService {
    @Autowired
    private HadirRepo hadirRepo;

    @Autowired
    private UserRepo userRepo;

    public Kehadiran absensiPasien (HadirDto hadirDto) {
        Kehadiran kehadiran = new Kehadiran();
        String uuid = generateShortUUID();

        Users users = userRepo.findByUserId(hadirDto.getUsers().getUserId());

        kehadiran.setHadirId(uuid);

        kehadiran.setUsers(users);

        return hadirRepo.save(kehadiran);
    }

    public List<Kehadiran> kehadiranPasien(Users users, StatusKehadiran status,  LocalDateTime start, LocalDateTime end){
        return hadirRepo.findByUsersAndStatusAndWaktuKehadiranBetween(users, status, start, end);
    }

    private String generateShortUUID() {
        String uuid = UUID.randomUUID().toString();
        return uuid.substring(0, 7);
    }
}
