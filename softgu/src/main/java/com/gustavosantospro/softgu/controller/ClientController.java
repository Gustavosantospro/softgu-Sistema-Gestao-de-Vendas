package com.gustavosantospro.softgu.controller;


import com.gustavosantospro.softgu.model.Client;
import com.gustavosantospro.softgu.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/home/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/listarClientes")
    public ResponseEntity<List<Client>> getAllClients() {
        return ResponseEntity.ok(clientService.getAllClients());
    }

    @PostMapping("/criarCliente")
    public void createClient(@RequestBody Client client) {

        clientService.createClient(client);
    }

}
