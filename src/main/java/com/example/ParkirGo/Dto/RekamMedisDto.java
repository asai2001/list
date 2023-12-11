package com.example.ParkirGo.Dto;

import com.example.ParkirGo.Entity.Users;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RekamMedisDto {
    private String rekamId;
    private String diagnosa;
    private Users users;
}
