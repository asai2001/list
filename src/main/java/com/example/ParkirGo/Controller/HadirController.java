package com.example.ParkirGo.Controller;

import com.example.ParkirGo.Dto.HadirDto;
import com.example.ParkirGo.Entity.Kehadiran;
import com.example.ParkirGo.Entity.StatusKehadiran;
import com.example.ParkirGo.Entity.Users;
import com.example.ParkirGo.Service.KehadiranService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/api/hadir")
@Api(tags = "Kehadiran COntroller", description = "API untuk mengelola kehadiran pasien")
public class HadirController {

    @Autowired
    private KehadiranService hadirService;

    @PostMapping
    @ApiOperation(value = "Absensi Pasien", notes = "Merekam Kehadiran Pasien")
    public ResponseEntity<?> absen (@RequestBody HadirDto hadirDto){
        return new ResponseEntity<>(hadirService.absensiPasien(hadirDto), HttpStatus.CREATED);
    }

    @GetMapping("/antara-waktu")
    @ApiOperation(value = "Kehadiran Pasien", notes = "Mengambil daftar kehadiran pasien dalam rentang waktu tertentu")
    public List<Kehadiran> kehadiranPasien (@RequestParam String userId,
                                            @RequestParam StatusKehadiran status,
                                            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
                                            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end) {
        Users users = new Users();
        users.setUserId(userId);
        return hadirService.kehadiranPasien(users,status,start,end);
    }
}
