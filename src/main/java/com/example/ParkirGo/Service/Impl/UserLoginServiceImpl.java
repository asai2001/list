package com.example.ParkirGo.Service.Impl;

import com.example.ParkirGo.Dto.LoginDto;
import com.example.ParkirGo.Entity.Users;
import com.example.ParkirGo.Repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

@Service
@RequiredArgsConstructor
@Transactional
public class UserLoginServiceImpl {

    @Autowired
    private UserRepo userRepo;

    public String authenticateUser(LoginDto loginDto) {
        Users users = userRepo.findByEmail(loginDto.getEmail());

        if (users != null && users.getPassword().equals(loginDto.getPassword())) {
            return users.getRole();
        }
        return null;
    }
}
