package com.example.ParkirGo.Controller;

import com.example.ParkirGo.Dto.RekamMedisDto;
import com.example.ParkirGo.Service.RekamService;
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
@RequestMapping("/rekam")
public class RekamController {
    @Autowired
    RekamService rekamService;

    @PostMapping("/create")
    public ResponseEntity<?> createrekam (@RequestBody RekamMedisDto rekamDto){
        return new ResponseEntity<>(rekamService.rekamMedis(rekamDto), HttpStatus.CREATED);
    }
}
