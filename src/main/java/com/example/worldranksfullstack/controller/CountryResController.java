package com.example.worldranksfullstack.controller;

import com.example.worldranksfullstack.feign.CountryClient;
import com.example.worldranksfullstack.model.CountryModel;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/hello")
public class CountryResController {
    private final CountryClient countryClient;


    public CountryResController(CountryClient countryClient) {
        this.countryClient = countryClient;
    }

    @GetMapping("/get")
    public HttpEntity<?> getAll() {
        List<CountryModel> all = countryClient.getAll();

        return ResponseEntity.ok(all);

    }
}
