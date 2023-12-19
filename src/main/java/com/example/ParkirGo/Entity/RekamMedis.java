package com.example.ParkirGo.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "rekam_medis")
public class RekamMedis {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rekam_id")
    private String rekamId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "daftar_id")
    private Pendaftaran pendaftaran;

    @Column(name = "keluhan")
    private String keluhan;

    @Column(name = "mens_terakhir")
    private String mensTerakhir;

    @Column(name = "diagnosa")
    private String diagnosa;
}
