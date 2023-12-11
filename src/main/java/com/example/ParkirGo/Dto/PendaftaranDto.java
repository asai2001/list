package com.example.ParkirGo.Dto;

import com.example.ParkirGo.Entity.RekamMedis;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PendaftaranDto {
    private String daftarId;
    private String keluhan;
    private String mensTerakhir;
    private RekamMedis rekamMedis;
}
