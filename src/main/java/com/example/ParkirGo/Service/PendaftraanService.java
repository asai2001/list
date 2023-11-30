package com.example.ParkirGo.Service;

import com.example.ParkirGo.Dto.PendaftaranDto;
import com.example.ParkirGo.Entity.Pendaftaran;
import com.example.ParkirGo.Entity.RekamMedis;
import com.example.ParkirGo.Repository.PendaftaranRepo;
import com.example.ParkirGo.Repository.RekamRepo;
import com.example.ParkirGo.encryption.Vigenere64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PendaftraanService {

    @Autowired
    PendaftaranRepo pendaftaranRepo;

    @Autowired
    RekamRepo rekamRepo;

    public Pendaftaran daftar (PendaftaranDto pendaftaranDto){
        Pendaftaran daftar = new Pendaftaran();
        Vigenere64 vigenere64 = new Vigenere64();

        RekamMedis rekamMedis = rekamRepo.findByRekamId(daftar.getRekamMedis().getRekamId());

        String uuid = generateShortUUID();

        String encryptDaftarId = vigenere64.encrypt(uuid, "aris");
        daftar.setDaftarId(encryptDaftarId);
        String encryptKeluhan = vigenere64.encrypt(pendaftaranDto.getKeluhan(), "aris");
        daftar.setKeluhan(encryptKeluhan);
        String encryptMens = vigenere64.encrypt(pendaftaranDto.getMensTerakhir(), "aris");
        daftar.setMensTerakhir(encryptMens);
        daftar.setRekamMedis(rekamMedis);
        return pendaftaranRepo.save(daftar);
    }

    private String generateShortUUID() {
        String uuid = UUID.randomUUID().toString();
        return uuid.substring(0, 7);
    }
}
