package com.wealth.growwealth.service;

import com.wealth.growwealth.entity.Client;
import com.wealth.growwealth.entity.Portfolio;
import com.wealth.growwealth.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

}
