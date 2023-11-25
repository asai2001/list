package com.example.ParkirGo.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Embeddable
@Table(name = "rekam_medis")
public class RekamMedis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rekam_id")
    private Integer rekamId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    List<Users> userss;

    @Column(name = "diagnosa")
    private String diagnosa;
}
