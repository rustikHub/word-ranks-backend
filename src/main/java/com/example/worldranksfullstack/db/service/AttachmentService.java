package com.example.worldranksfullstack.db.service;

import com.example.worldranksfullstack.db.entity.Attachment;
import com.example.worldranksfullstack.db.entity.AttachmentContent;
import com.example.worldranksfullstack.db.repository.AttachmentRepository;
import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.Locale;
import java.util.Optional;
import java.util.UUID;

@Service
public class AttachmentService implements AttachmentServiceInterface {

    private final AttachmentRepository attachmentRepository;

    public AttachmentService(AttachmentRepository attachmentRepository) {
        this.attachmentRepository = attachmentRepository;
    }

    @Override
    public Attachment save(Attachment attachment) {
        return null;
    }

    @Override
    public Attachment save(File file) {
        return null;
    }

    @Override
    public Attachment save(byte[] bytes, String filename, String extension) {
        return null;
    }

    @Override
    public AttachmentContent getContent(UUID attachmentId) {
        return null;
    }

    @Override
    public File getContentAsFile(UUID attachmentId) {
        return null;
    }

    @Override
    public byte[] getContentAsByteArray(UUID attachmentId) {
        return new byte[0];
    }

    @Override
    public byte[] getContentByNameAsByteArray(String name) {
        Optional<Attachment> byName = attachmentRepository.findByName(name.toUpperCase(Locale.ROOT));

        if (byName.isPresent()) {
            byte[] bytes = byName.get().getAttachmentContent().getBytes().getBytes();

            //TODO: before returning bytes check if the file is (uz: butun)

            return bytes;
        } else {
            return new byte[0];
        }


    }

    @Override
    public HttpEntity<?> getContentByName(String name, HttpServletResponse response) {
        Optional<Attachment> byName = attachmentRepository.findByName(name.toUpperCase(Locale.ROOT));

        if (byName.isPresent()) {
            Attachment attachment = byName.get();
            AttachmentContent attachmentContent = attachment.getAttachmentContent();

            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(attachment.getExtension()))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + attachment.getName() + "\"")
                    .contentLength(attachment.getSize())
                    .body(attachmentContent.getBytes());
        } else {
            return null;
        }

    }
}