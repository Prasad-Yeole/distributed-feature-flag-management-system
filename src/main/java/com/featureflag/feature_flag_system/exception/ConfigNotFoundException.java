package com.featureflag.feature_flag_system.exception;

public class ConfigNotFoundException extends RuntimeException {

    public ConfigNotFoundException(String message) {
        super(message);
    }
}