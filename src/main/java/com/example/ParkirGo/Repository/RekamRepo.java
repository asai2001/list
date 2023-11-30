package com.example.ParkirGo.Repository;

import com.example.ParkirGo.Entity.RekamMedis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface RekamRepo extends JpaRepository<RekamMedis, Integer> {
    RekamMedis findByRekamId (String rekamId);
}
