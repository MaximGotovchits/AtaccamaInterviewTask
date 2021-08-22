package com.project.ataccama.service;

import com.project.ataccama.exception.ConnectionDetailsException;
import com.project.ataccama.model.ConnectionDetails;
import com.project.ataccama.repository.ConnectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConnectionService {
    @Autowired
    private ConnectionRepository connectionRepository;

    public void save(String name,
                     String hostname,
                     String port,
                     String databaseName,
                     String username,
                     String password) {
        if (connectionRepository.findById(name).isPresent()) {
            throw new ConnectionDetailsException("Database with name " + name + " already exists");
        }
        ConnectionDetails newConnection = new ConnectionDetails(name, hostname, port, databaseName, username, password);
        connectionRepository.save(newConnection);
    }

    public Iterable<ConnectionDetails> list() {
        return connectionRepository.findAll();
    }

    public void update(String name,
                     String hostname,
                     String port,
                     String databaseName,
                     String username,
                     String password) {
        ConnectionDetails connectionToUpdate = connectionRepository.findById(name)
                .orElseThrow(() -> new ConnectionDetailsException("No database with name: " + name));

        connectionToUpdate.setHostname(hostname);
        connectionToUpdate.setPort(port);
        connectionToUpdate.setDatabaseName(databaseName);
        connectionToUpdate.setUsername(username);
        connectionToUpdate.setPassword(password);

        connectionRepository.save(connectionToUpdate);
    }

    public void delete(String name) {
        if (connectionRepository.findById(name).isEmpty()) {
            throw new ConnectionDetailsException("No database with name: " + name);
        }
        connectionRepository.deleteById(name);
    }

    public ConnectionDetails getConnection(String name) {
        return connectionRepository.findById(name)
                .orElseThrow(() -> new ConnectionDetailsException("No database with name: " + name));
    }
}
