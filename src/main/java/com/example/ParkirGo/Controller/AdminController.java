package com.example.ParkirGo.Controller;

import com.example.ParkirGo.Dto.AdminDto;
import com.example.ParkirGo.Service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    @Autowired
    AdminService adminService;

    @PostMapping("/register")
    public ResponseEntity<?> saveadmin (@RequestBody AdminDto adminDto) {
        try {
            adminService.admin(adminDto);
            return ResponseEntity.status(HttpStatus.CREATED).body("Registration Successful");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Registration Failed");
        }
    }

    @GetMapping("/dashboard")
    public String adminDasboard() {
        return "admin_dashboard";
    }
}
