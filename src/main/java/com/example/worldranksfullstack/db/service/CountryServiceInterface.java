package com.example.worldranksfullstack.db.service;

import com.example.worldranksfullstack.db.entity.Country;
import com.example.worldranksfullstack.model.CountryModel;
import org.springframework.http.HttpEntity;

import java.util.List;

public interface CountryServiceInterface {
    Country save(CountryModel countryModel);

    Country update(Country country);

    void delete(Country country);

    List<Country> getAll();

    HttpEntity<?> getById(String alpha3Code);
}