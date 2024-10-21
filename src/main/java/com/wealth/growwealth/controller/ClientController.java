package com.wealth.growwealth.controller;

import com.wealth.growwealth.entity.Client;
import com.wealth.growwealth.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;


    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        Client savedClient = clientService.saveClient(client);
        return ResponseEntity.ok(savedClient);
    }

    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

}
