package com.example.ParkirGo.Service;

import com.example.ParkirGo.Dto.AdminDto;
import com.example.ParkirGo.Entity.Admin;
import com.example.ParkirGo.Repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    AdminRepo adminRepo;

    public Admin admin (AdminDto adminDto){
        Admin admin = new Admin();
        admin.setNama(adminDto.getNama());
        admin.setNoHp(adminDto.getNoHp());
        admin.setAlamat(adminDto.getAlamat());
        admin.setEmail(adminDto.getEmail());
        admin.setPassword(adminDto.getPassword());
        return adminRepo.save(admin);
    }
}
