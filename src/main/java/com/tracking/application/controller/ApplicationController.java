package com.tracking.application.controller;


import com.tracking.application.model.AtsApplication;
import com.tracking.application.service.ApplicationService;
import com.tracking.application.service.NemotronService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    private final ApplicationService service;

    public ApplicationController(ApplicationService service, NemotronService nemotronService) {
        this.service = service;
        this.nemotronService = nemotronService;
    }

    @GetMapping
    public String getAll() {
        System.out.println("Get all api called"+apiKey);

        return "\"Get all api called"+apiKey;
    }

    @GetMapping("/{id}")
    public AtsApplication getById(@PathVariable Long id) {
        return service.getById(id);
    }

    private final NemotronService nemotronService;
    @Value("${nvidia.api.key}")
    private String apiKey;

    @PostMapping("/summarize")
    public String summarizeApplication(@RequestBody String applicationText) {
        System.out.println("API KEY LOADED: " + apiKey);
        String prompt = "Summarize this job application in 2 sentences: " + applicationText;
        return "ResponseEntity.ok(nemotronService.getCompletion(prompt))";
    }

    @PostMapping
    public ResponseEntity<AtsApplication> create(@Valid @RequestBody AtsApplication application) {
        AtsApplication created = service.create(application);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public AtsApplication update(@PathVariable Long id, @Valid @RequestBody AtsApplication application) {
        return service.update(id, application);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
