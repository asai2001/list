package com.example.ParkirGo.Dto;

import com.example.ParkirGo.Entity.Pendaftaran;
import com.example.ParkirGo.Entity.Users;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RekamMedisDto {
    private String rekamId;
    private String keluhan;
    private String mensTerakhir;
    private String diagnosa;
    private Pendaftaran pendaftaran;
}
