package com.example.ParkirGo.Controller;

import com.example.ParkirGo.Dto.LoginDto;
import com.example.ParkirGo.Service.Impl.UserLoginServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class LoginController {

    @Autowired
    private UserLoginServiceImpl userLoginService;

    @PostMapping("/auth/login")
    public ResponseEntity<?> loginUser (@RequestBody LoginDto loginDto) {
        try {
            String role = userLoginService.authenticateUser(loginDto);

            if (role != null) {
                return ResponseEntity.ok(role);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login Failed");

            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed");
        }
    }
}
