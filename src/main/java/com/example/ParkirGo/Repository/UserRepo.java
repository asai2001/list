package com.example.ParkirGo.Repository;

import com.example.ParkirGo.Entity.Users;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface UserRepo extends JpaRepository<Users, Integer> {

    List<Users> findAll();
    Users findByUserId (int userId);

}
