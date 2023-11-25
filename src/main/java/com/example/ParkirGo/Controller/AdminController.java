package com.example.ParkirGo.Controller;

import com.example.ParkirGo.Dto.AdminDto;
import com.example.ParkirGo.Service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    @Autowired
    AdminService adminService;

    @PostMapping("/register")
    public ResponseEntity<?> saveadmin (@RequestBody AdminDto adminDto) {
        return new ResponseEntity<>(adminService.admin(adminDto), HttpStatus.CREATED);
    }
}
