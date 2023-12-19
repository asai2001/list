package com.example.ParkirGo.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Dokter {
    @Id
    @Column(name = "dokter_id")
    private String dokterId;

    @Column(name = "nama_lengkap")
    private String namaLengkap;

    @Column(name = "no_telp")
    private String noTelp;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;
}
