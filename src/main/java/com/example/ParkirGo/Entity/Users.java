package com.example.ParkirGo.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "users")
public class Users {
    @Id
    @Column(name = "user_id")
    private String userId;

    @Column(name = "nama_lengkap")
    private String namaLengkap;

    @Column(name = "nama_suami")
    private String namaSuami;

    @Column(name = "umur")
    private String umur;

//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")

    @Column(name = "no_telp")
    private String noTelp;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;



//    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
//    List<Pendaftaran> daftar;

//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "user_role",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id"))
//    private List<Role> roles;
}
