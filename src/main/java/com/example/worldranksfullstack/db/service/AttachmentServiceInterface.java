package com.example.worldranksfullstack.db.service;

import com.example.worldranksfullstack.db.entity.Attachment;
import com.example.worldranksfullstack.db.entity.AttachmentContent;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.UUID;

public interface AttachmentServiceInterface {
    Attachment save(Attachment attachment);

    Attachment save(File file);

    Attachment save(byte[] bytes, String filename, String extension);

    AttachmentContent getContent(UUID attachmentId);

    File getContentAsFile(UUID attachmentId);

    byte[] getContentAsByteArray(UUID attachmentId);

    byte[] getContentByNameAsByteArray(String name);

    HttpEntity<?> getContentByName(String name, HttpServletResponse response);
}
