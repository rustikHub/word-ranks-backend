package com.example.worldranksfullstack.db.repository;

import com.example.worldranksfullstack.db.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, Integer> {
    Optional<Country> findByAlpha3Code(String alpha3Code);
}