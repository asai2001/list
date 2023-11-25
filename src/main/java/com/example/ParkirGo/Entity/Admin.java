package com.example.ParkirGo.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "admin")

public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private Integer adminId;

    @Column(name = "nama")
    private String nama;

    @Column(name = "no_hp")
    private String noHp;

    @Column(name = "alamat")
    private String alamat;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;
}
