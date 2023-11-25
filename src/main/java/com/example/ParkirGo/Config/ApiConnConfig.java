package com.example.ParkirGo.Config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Scanner;


//this class for another api connect to this project
@RestController
public class ApiConnConfig {

    //mahasiswa api
    @GetMapping("/mahasiswa/{nim}")
    public Map<String, Object> getDataMhs(@PathVariable int nim) throws IOException {
        URL url = new URL("http://simft.umpo.ac.id/backend-practice/api/claim/mahasiswa/" + nim);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        StringBuilder informationString = new StringBuilder();
        Scanner scanner = new Scanner(url.openStream());

        while (scanner.hasNext()) {
            informationString.append(scanner.nextLine());
        }
        // Close the scanner
        scanner.close();

        // Parse the JSON response
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> responseData = objectMapper.readValue(informationString.toString(), new TypeReference<Map<String, Object>>() {});

        // Add the 'role' to the response
        responseData.put("role", "mahasiswa");

        return responseData;
    }

    //dosen api
    @GetMapping("/dosen/{nik}")
    public Map<String, Object> getDataDosen(@PathVariable String nik) throws IOException {
        URL url = new URL("http://simft.umpo.ac.id/backend-practice/api/claim/dosen/" + nik);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        StringBuilder informationString = new StringBuilder();
        Scanner scanner = new Scanner(url.openStream());

        while (scanner.hasNext()) {
            informationString.append(scanner.nextLine());
        }
        // Close the scanner
        scanner.close();

        // Parse the JSON response
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> responseData = objectMapper.readValue(informationString.toString(), new TypeReference<Map<String, Object>>() {});

        // Add the 'role' to the response
        responseData.put("role", "dosen");

        return responseData;
    }



}
