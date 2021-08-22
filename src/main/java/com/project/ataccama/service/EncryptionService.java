package com.project.ataccama.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;

public class EncryptionService {
    @Value("${encrypted.property}")
    private String property;

    public String getProperty() {
        return property;
    }

    public String getPasswordUsingEnvironment(Environment environment) {
        return environment.getProperty("encrypted.property");
    }
}
