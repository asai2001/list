package com.example.ParkirGo.Service;

import com.example.ParkirGo.Dto.PendaftaranDto;
import com.example.ParkirGo.Entity.Dokter;
import com.example.ParkirGo.Entity.Pendaftaran;
import com.example.ParkirGo.Entity.RekamMedis;
import com.example.ParkirGo.Entity.Users;
import com.example.ParkirGo.Repository.DokterRepo;
import com.example.ParkirGo.Repository.PendaftaranRepo;
import com.example.ParkirGo.Repository.RekamRepo;
import com.example.ParkirGo.Repository.UserRepo;
import com.example.ParkirGo.encryption.Vigenere64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PendaftraanService {

    @Autowired
    PendaftaranRepo pendaftaranRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    DokterRepo dokterRepo;

    public Pendaftaran daftar (PendaftaranDto pendaftaranDto){
        Pendaftaran daftar = new Pendaftaran();
        Vigenere64 vigenere64 = new Vigenere64();

        final String key = "aris";

        Users users = userRepo.findByUserId(pendaftaranDto.getUsers().getUserId());
        Dokter dokter = dokterRepo.findByDokterId(pendaftaranDto.getDokter().getDokterId());

        String uuid = generateShortUUID();

        String encryptDaftarId = vigenere64.encrypt(uuid, key);
        daftar.setDaftarId(encryptDaftarId);
        String encrypTgl = vigenere64.encrypt(pendaftaranDto.getTglDaftar(), key);
        daftar.setTglDaftar(encrypTgl);
        daftar.setUsers(users);
        daftar.setDokter(dokter);
        return pendaftaranRepo.save(daftar);
    }

    private String generateShortUUID() {
        String uuid = UUID.randomUUID().toString();
        return uuid.substring(0, 7);
    }
}
