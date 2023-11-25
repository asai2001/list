package com.example.ParkirGo.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "pendaftaran")
public class Pendaftaran {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "daftar_id")
    private Integer daftarId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rekam_id")
    private RekamMedis rekamMediss;

    @Column(name = "keluhan")
    private String keluhan;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "mens_terakhir")
    private Date mensTerakhir;

}
