package com.example.ParkirGo.Repository;

import com.example.ParkirGo.Entity.Kehadiran;
import com.example.ParkirGo.Entity.StatusKehadiran;
import com.example.ParkirGo.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Repository
@Transactional
public interface HadirRepo extends JpaRepository<Kehadiran, Integer> {
    List<Kehadiran> findByUsersAndStatusAndWaktuKehadiranBetween (Users users, StatusKehadiran status, LocalDateTime start, LocalDateTime end);

}
