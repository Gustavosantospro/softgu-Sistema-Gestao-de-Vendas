package com.gustavosantospro.softgu.service;

import com.gustavosantospro.softgu.model.Client;

import java.util.List;

public interface ClientService {

    List<Client> getAllClients();

    void createClient(Client client);
}
