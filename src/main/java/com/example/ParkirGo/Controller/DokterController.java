package com.example.ParkirGo.Controller;

import com.example.ParkirGo.Dto.DokterDto;
import com.example.ParkirGo.Service.DokterService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/dokter")
public class DokterController {
    @Autowired
    DokterService dokterService;

    @PostMapping
    public ResponseEntity<?> add_dokter (@RequestBody DokterDto dokterDto) {
        return new ResponseEntity<>(dokterService.saveDokter(dokterDto), HttpStatus.CREATED);
    }
}
