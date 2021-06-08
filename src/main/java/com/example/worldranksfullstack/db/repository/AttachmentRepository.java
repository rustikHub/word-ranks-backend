package com.example.worldranksfullstack.db.repository;

import com.example.worldranksfullstack.db.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AttachmentRepository extends JpaRepository<Attachment, UUID> {
    Optional<Attachment> findByName(String name);
}