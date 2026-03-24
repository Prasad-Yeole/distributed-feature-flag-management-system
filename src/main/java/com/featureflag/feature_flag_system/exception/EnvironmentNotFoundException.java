package com.featureflag.feature_flag_system.exception;

public class EnvironmentNotFoundException extends RuntimeException {

    public EnvironmentNotFoundException(String message) {
        super(message);
    }
}