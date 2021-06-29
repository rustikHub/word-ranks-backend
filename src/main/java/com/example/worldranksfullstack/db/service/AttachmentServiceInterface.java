package com.example.worldranksfullstack.db.service;

import org.springframework.http.HttpEntity;

import javax.servlet.http.HttpServletResponse;

public interface AttachmentServiceInterface {
  /*  Attachment save(Attachment attachment);

    Attachment save(File file);

    Attachment save(byte[] bytes, String filename, String extension);

    AttachmentContent getContent(UUID attachmentId);

    File getContentAsFile(UUID attachmentId);

    byte[] getContentAsByteArray(UUID attachmentId);

    byte[] getContentByNameAsByteArray(String name);*/

    HttpEntity<?> getContentByName(String name, HttpServletResponse response);
}
