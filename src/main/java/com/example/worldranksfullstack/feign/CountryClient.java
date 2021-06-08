package com.example.worldranksfullstack.feign;

import com.example.worldranksfullstack.config.FeignConfiguration;
import com.example.worldranksfullstack.model.CountryModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "countryClient", url = "https://restcountries.eu/rest/v2", configuration = FeignConfiguration.class)
public interface CountryClient {

    @GetMapping("all")
    public List<CountryModel> getAll();

}
