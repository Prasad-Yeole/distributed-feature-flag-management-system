package com.featureflag.feature_flag_system.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.featureflag.feature_flag_system.model.Environment;
import com.featureflag.feature_flag_system.repository.EnvironmentRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/environments")
public class EnvironmentController {

    private final EnvironmentRepository envRepo;

    public EnvironmentController(EnvironmentRepository envRepo) {
        this.envRepo = envRepo;
    }

    @GetMapping
    public List<Environment> getAllEnvironments() {
        return envRepo.findAll();
    }
}