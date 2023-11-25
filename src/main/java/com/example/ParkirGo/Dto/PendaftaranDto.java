package com.example.ParkirGo.Dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PendaftaranDto {
    private Integer daftarId;
    private String keluhan;
    private Date mensTerakhir;
}
