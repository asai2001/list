package com.example.ParkirGo.Controller;

import com.example.ParkirGo.Dto.UsersDto;
import com.example.ParkirGo.Service.Impl.UserLoginServiceImpl;
import com.example.ParkirGo.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@CrossOrigin
public class UserController {

    @Autowired
    private UserLoginServiceImpl userLoginService;

    @PostMapping("/register")
    public ResponseEntity<?> saveuser (@RequestBody UsersDto usersDto) {
       try {
           userLoginService.registUser(usersDto);
           return ResponseEntity.status(HttpStatus.CREATED).body("Registration Successful");
       } catch (RuntimeException e) {
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
       } catch (Exception e) {
           e.printStackTrace();
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Registration Failed");
       }
    }

    @GetMapping("/dashboard")
    public String userDashboard() {
        return "user_dashboard";
    }

}
