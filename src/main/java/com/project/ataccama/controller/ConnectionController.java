package com.project.ataccama.controller;

import com.project.ataccama.model.ConnectionDetails;
import com.project.ataccama.service.ConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/credentials")
public class ConnectionController {
    @Autowired
    private ConnectionService connectionService;

    @GetMapping("/list")
    public @ResponseBody Iterable<ConnectionDetails> getAllConnections() {
        return connectionService.list();
    }

    @GetMapping("/find")
    public @ResponseBody ConnectionDetails getConnection(@RequestParam String name) {
        return connectionService.getConnection(name);
    }

    @PostMapping("/save")
    public @ResponseBody String saveConnection(
            @RequestParam String name,
            @RequestParam String hostname,
            @RequestParam String port,
            @RequestParam String databaseName,
            @RequestParam String username,
            @RequestParam String password
    ) {
        connectionService.save(name, hostname, port, databaseName, username, password);
        return "Added.";
    }

    @PostMapping("/update")
    public @ResponseBody String updateConnection(
            @RequestParam String name,
            @RequestParam String hostname,
            @RequestParam String port,
            @RequestParam String databaseName,
            @RequestParam String username,
            @RequestParam String password
    ) {
        connectionService.update(name, hostname, port, databaseName, username, password);
        return "Updated.";

    }

    @PostMapping("/delete")
    public @ResponseBody String deleteConnection(@RequestParam String name) {
        connectionService.delete(name);
        return "Deleted.";
    }
}
