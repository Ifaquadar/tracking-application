package com.tracking.application.service;

import com.tracking.application.model.AtsApplication;
import com.tracking.application.repository.ApplicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {
    private final ApplicationRepository repository;

    public ApplicationService(ApplicationRepository repository) {
        this.repository = repository;
    }

    public List<AtsApplication> getAll() {
        return repository.findAll();
    }

    public AtsApplication getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Application not found with id: " + id));
    }

    public AtsApplication create(AtsApplication application) {
        return repository.save(application);
    }

    public AtsApplication update(Long id, AtsApplication updated) {
        AtsApplication existing = getById(id);
        existing.setCompanyName(updated.getCompanyName());
        existing.setJobTitle(updated.getJobTitle());
        existing.setStatus(updated.getStatus());
        existing.setAppliedDate(updated.getAppliedDate());
        existing.setJobUrl(updated.getJobUrl());
        existing.setNotes(updated.getNotes());
        existing.setLocation(updated.getLocation());
        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
