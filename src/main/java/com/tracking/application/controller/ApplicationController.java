package com.tracking.application.controller;


import com.tracking.application.Application;
import com.tracking.application.model.AtsApplication;
import com.tracking.application.service.ApplicationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
@RequiredArgsConstructor
public class ApplicationController {

    private final ApplicationService service;

    @GetMapping
    public List<AtsApplication> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public AtsApplication getById(@PathVariable Long id) {
        return service.getById(id);
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
