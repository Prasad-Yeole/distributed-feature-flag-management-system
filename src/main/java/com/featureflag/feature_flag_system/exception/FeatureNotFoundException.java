package com.featureflag.feature_flag_system.exception;

public class FeatureNotFoundException extends RuntimeException {

    public FeatureNotFoundException(String message) {
        super(message);
    }
}