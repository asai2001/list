package com.example.ParkirGo.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "kehadiran")
public class Kehadiran {
    @Id
    @Column(name = "hadir_id")
    private String hadirId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;

    private LocalDateTime waktuKehadiran;

    @Enumerated(EnumType.STRING)
    private StatusKehadiran status;
}
