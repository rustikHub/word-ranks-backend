package com.example.worldranksfullstack.db.repository;

import com.example.worldranksfullstack.db.entity.Info;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.Optional;

public interface InfoRepository extends JpaRepository<Info, Integer> {
    Optional<Info> findFirstByRequestDateIsBefore(Date requestDate);
}
