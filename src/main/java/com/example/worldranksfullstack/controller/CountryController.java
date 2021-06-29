package com.example.worldranksfullstack.controller;

import com.example.worldranksfullstack.db.entity.Country;
import com.example.worldranksfullstack.db.service.CountryService;
import com.example.worldranksfullstack.payload.ResCountry;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("country")
public class CountryController {
    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("{alpha3Code}")
    public HttpEntity<?> get(@PathVariable String alpha3Code) {
       return countryService.getById(alpha3Code);
    }

    @GetMapping("/all")
    public HttpEntity<?> getAll() {
        List<Country> allCountries = countryService.getAll();

        //  throw new UserNotFoundException("User not found");

        List<ResCountry> all = allCountries.stream().map(ResCountry::new).collect(Collectors.toList());

        return ResponseEntity.ok(all);
    }
}
