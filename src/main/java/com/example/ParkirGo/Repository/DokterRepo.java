package com.example.ParkirGo.Repository;

import com.example.ParkirGo.Entity.Dokter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DokterRepo extends JpaRepository<Dokter, Integer> {
    Dokter findByDokterId (String dokterId);
}
