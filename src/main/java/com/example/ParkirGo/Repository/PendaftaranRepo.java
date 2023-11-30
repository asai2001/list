package com.example.ParkirGo.Repository;

import com.example.ParkirGo.Entity.Pendaftaran;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface PendaftaranRepo extends JpaRepository<Pendaftaran, Integer> {

    Pendaftaran findByDaftarId (String daftarId);
}
