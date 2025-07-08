package com.example.test.Services;

import com.example.test.Models.Client;
import com.example.test.Repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;


    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Optional<Client> getClientById(int id) {
        return clientRepository.findById(id);
    }

    public Client updateClient(int id, Client updatedClient) {
        return clientRepository.findById(id).map(client -> {
            client.setCin(updatedClient.getCin());
            client.setMatricule(updatedClient.getMatricule());
            client.setNom(updatedClient.getNom());
            client.setPrenom(updatedClient.getPrenom());
            client.setSexe(updatedClient.getSexe());
            client.setNumtel(updatedClient.getNumtel());
            return clientRepository.save(client);
        }).orElse(null);
    }

    public boolean deleteClient(int id) {
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
