package com.example.worldranksfullstack.db.repository;

import com.example.worldranksfullstack.db.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer> {

}