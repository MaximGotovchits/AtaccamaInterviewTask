package com.project.ataccama.controller;

import com.project.ataccama.exception.ConnectionDetailsException;
import com.project.ataccama.model.ConnectionDetails;
import com.project.ataccama.repository.CredentialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/credentials")
public class CredentialsController {
    @Autowired
    private CredentialsRepository credentialsRepository;

    @GetMapping("/list")
    public @ResponseBody Iterable<ConnectionDetails> getAllCredentials() {
        return credentialsRepository.findAll();
    }

    @PostMapping("/save")
    public @ResponseBody String saveCredentials(
            @RequestParam String name,
            @RequestParam String hostname,
            @RequestParam String port,
            @RequestParam String databaseName,
            @RequestParam String username,
            @RequestParam String password
    ) {
        if (credentialsRepository.findById(name).isPresent()) {
            throw new ConnectionDetailsException("Database with name " + name + " already exists");
        }
        ConnectionDetails newConnection = new ConnectionDetails(name, hostname, port, databaseName, username, password);
        credentialsRepository.save(newConnection);
        return "Added.";
    }

    @PostMapping("/update")
    public @ResponseBody String updateCredentials(
            @RequestParam String name,
            @RequestParam String hostname,
            @RequestParam String port,
            @RequestParam String databaseName,
            @RequestParam String username,
            @RequestParam String password
    ) {
        ConnectionDetails connectionToUpdate = credentialsRepository.findById(name)
                .orElseThrow(() -> new ConnectionDetailsException("No database with name: " + name));

        connectionToUpdate.setHostname(hostname);
        connectionToUpdate.setPort(port);
        connectionToUpdate.setDatabaseName(databaseName);
        connectionToUpdate.setUsername(username);
        connectionToUpdate.setPassword(password);

        credentialsRepository.save(connectionToUpdate);
        return "Updated.";

    }

    @PostMapping("/delete")
    public @ResponseBody String deleteCredentials(@RequestParam String name) {
        if (credentialsRepository.findById(name).isEmpty()) {
            throw new ConnectionDetailsException("No database with name: " + name);
        }
        credentialsRepository.deleteById(name);
        return "Deleted.";
    }
}
