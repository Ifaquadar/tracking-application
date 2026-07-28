package com.tracking.application.controller;

import com.tracking.application.service.NemotronService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/ai")
public class AiController {
    private final NemotronService nemotronService;
    @Value("${nvidia.api.key}")
    private String apiKey;

    public AiController(NemotronService nemotronService) {
        this.nemotronService = nemotronService;
    }

    @PostMapping("/summarize")
    public ResponseEntity<String> summarizeApplication(@RequestBody String applicationText) {
        System.out.println("API KEY LOADED: " + apiKey);
        String prompt = "Summarize this job application in 2 sentences: " + applicationText;
        return ResponseEntity.ok(nemotronService.getCompletion(prompt));
    }
}
