package com.example.worldranksfullstack.controller;

import com.example.worldranksfullstack.db.service.AttachmentService;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("data")
public class DataController {
    private final AttachmentService attachmentService;

    public DataController(AttachmentService attachmentService) {
        this.attachmentService = attachmentService;
    }

    @GetMapping("img/{alpha3Code}")
    public HttpEntity<?> getImageData(@PathVariable("alpha3Code") String alpha3Code, HttpServletResponse response) {
        return attachmentService.getContentByName(alpha3Code, response);
    }
}
