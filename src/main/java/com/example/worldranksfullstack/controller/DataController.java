package com.example.worldranksfullstack.controller;

import com.example.worldranksfullstack.db.service.AttachmentService;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("data")
@CrossOrigin
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
