package com.example.ParkirGo.Dto;

import com.example.ParkirGo.Entity.Dokter;
import com.example.ParkirGo.Entity.RekamMedis;
import com.example.ParkirGo.Entity.Users;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PendaftaranDto {
    private String daftarId;
    private Users users;
    private Dokter dokter;
    private String tglDaftar;
}
