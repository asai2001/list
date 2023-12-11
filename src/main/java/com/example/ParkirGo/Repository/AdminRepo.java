package com.example.ParkirGo.Repository;

import com.example.ParkirGo.Entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface AdminRepo extends JpaRepository<Admin, Integer> {
    List<Admin> findAll();
    Admin findByAdminId (String adminId);
}
