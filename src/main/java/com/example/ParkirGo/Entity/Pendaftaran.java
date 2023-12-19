package com.example.ParkirGo.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Column(name = "daftar_id")
    private String daftarId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    @JsonIgnore // Menghindari pencetakan tak terbatas dengan mengabaikan relasi ini
    Users users;

    @ManyToOne(cascade =CascadeType.ALL)
    @JoinColumn(name = "dokter_id")
    Dokter dokter;

    @Column(name = "tgl_daftar")
    private String tglDaftar;





//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")

}
