package com.featureflag.feature_flag_system.controller;



import org.springframework.web.bind.annotation.*;
import com.featureflag.feature_flag_system.model.FeatureFlag;
import com.featureflag.feature_flag_system.service.FeatureFlagService;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/features")
public class FeatureFlagController {

    private final FeatureFlagService service;

    public FeatureFlagController(FeatureFlagService service) {
        this.service = service;
    }

    @PostMapping
    public FeatureFlag createFeature(@RequestBody FeatureFlag feature) {
        return service.createFeature(feature);
    }

    @GetMapping
    public List<FeatureFlag> getAllFeatures() {
        return service.getAllFeatures();
    }

    @GetMapping("/{id}")
    public FeatureFlag getFeature(@PathVariable String id) {
        return service.getFeatureById(id);
    }

    @PutMapping("/{id}")
    public FeatureFlag updateFeature(
            @PathVariable("id") String id,
            @RequestBody FeatureFlag feature) {
        return service.updateFeature(id, feature);
    }
    
    @DeleteMapping("/{id}")
    public void deleteFeature(@PathVariable("id") String id) {
        service.deleteFeature(id);
    }
}
