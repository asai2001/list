package com.example.ParkirGo.Controller;

import com.example.ParkirGo.Dto.LoginDto;
import com.example.ParkirGo.Dto.UsersDto;
import com.example.ParkirGo.Entity.Users;
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
    UserLoginServiceImpl userLoginService;

    @PostMapping("/login")
    public ResponseEntity<?> login (@RequestBody UsersDto usersDto) {
        Users userLogin = userLoginService.findByEmail(usersDto.getEmail());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
