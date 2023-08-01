package com.gustavosantospro.softgu.service.impl;


import com.gustavosantospro.softgu.model.Client;
import com.gustavosantospro.softgu.repository.ClientRepository;
import com.gustavosantospro.softgu.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> getAllClients() {

        return clientRepository.findAll();
    }

    @Override
    public void createClient(Client client) {
        clientRepository.save(client);
    }
}
