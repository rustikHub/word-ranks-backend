package com.example.worldranksfullstack.db.repository;

import com.example.worldranksfullstack.db.entity.Translations;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TranslationsRepository extends JpaRepository<Translations, Integer> {

}