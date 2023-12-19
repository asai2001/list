package com.example.ParkirGo.Service.Impl;

import com.example.ParkirGo.Entity.Users;

public interface UserImplService {
    Users findByEmail (String email);
}
