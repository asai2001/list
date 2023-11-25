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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rekam_id")
    private Integer rekamId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "users_id")
    @JsonIgnore // Menghindari pencetakan tak terbatas dengan mengabaikan relasi ini
    Users users;
    @Column(name = "diagnosa")
    private String diagnosa;
}
