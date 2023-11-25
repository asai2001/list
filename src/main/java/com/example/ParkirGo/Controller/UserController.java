package com.example.ParkirGo.Controller;

import com.example.ParkirGo.Dto.UsersDto;
import com.example.ParkirGo.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> saveuser (@RequestBody UsersDto usersDto) {
        return new ResponseEntity<>(userService.user(usersDto),HttpStatus.CREATED);
    }

}
