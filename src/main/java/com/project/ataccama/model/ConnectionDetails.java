package com.project.ataccama.model;

import lombok.Data;

@Data
public class ConnectionDetails {
    private String name;
    private String hostname;
    private String port;
    private String databaseName;
    private String username;
    private String password;
}
