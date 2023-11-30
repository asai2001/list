package com.example.ParkirGo.Controller;

import com.example.ParkirGo.Dto.PendaftaranDto;
import com.example.ParkirGo.Service.PendaftraanService;
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
@RequestMapping("/daftar")
public class DaftarController {
    @Autowired
    PendaftraanService pendaftraanService;

    @PostMapping("/regist")
    public ResponseEntity<?> create (@RequestBody PendaftaranDto pendaftaranDto){
        return new ResponseEntity<>(pendaftraanService.daftar(pendaftaranDto),HttpStatus.CREATED);
    }

}
