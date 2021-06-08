package com.example.worldranksfullstack.db.service;

import com.example.worldranksfullstack.db.entity.Country;
import com.example.worldranksfullstack.model.CountryModel;

public interface CountryServiceInterface {
    Country save(CountryModel countryModel);

    Country update(Country country);

    void delete(Country country);
}