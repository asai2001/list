package com.example.ParkirGo.Dto;

import com.example.ParkirGo.Entity.StatusKehadiran;
import com.example.ParkirGo.Entity.Users;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class HadirDto {
    private String hadirId;
    private Users users;
    private LocalDateTime waktuKehadiran;
    private StatusKehadiran status;
}
