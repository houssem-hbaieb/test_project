package com.example.test.Controllers;

import com.example.test.Models.Client;
import com.example.test.Services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/client")
@RequiredArgsConstructor
public class ClientController {
@Autowired
private  ClientService client_service;


    @PostMapping
    public Client createClient(@RequestBody Client client) {
        return client_service.createClient(client);
    }

    @GetMapping
    public List<Client> getAllClients() {
        return client_service.getAllClients();
    }

    @GetMapping("/{id}")
    public Optional<Client> getClientById(@PathVariable int id) {
        return client_service.getClientById(id);
    }

//    @PutMapping("/{id}")
//    public Client updateClient(@PathVariable int id, @RequestBody Client client) {
//        return client_service.updateClient(id, client);
//    }

    @DeleteMapping("/{id}")
    public String deleteClient(@PathVariable int id) {
        boolean deleted = client_service.deleteClient(id);
        return deleted ? "Client deleted" : "Client not found";
    }


}
