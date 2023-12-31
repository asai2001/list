package com.example.ParkirGo.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UsersDto {

    private String userId;
    private String namaLengkap;
    private String namaSuami;
    private String umur;
    private String noTelp;
    private String email;
    private String password;
    private String role;

}
