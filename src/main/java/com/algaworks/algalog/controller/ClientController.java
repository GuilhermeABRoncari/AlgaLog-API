package com.algaworks.algalog.controller;

import com.algaworks.algalog.domain.dto.ClientDTO;
import com.algaworks.algalog.domain.entity.Client;
import com.algaworks.algalog.domain.reposiotry.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    private ClientRepository clientRepository;
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Client> listClients(){
        var list = clientRepository.findAll().stream().toList();
        return list;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client save(ClientDTO clientDTO){
        var client = new Client(clientDTO.id() , clientDTO.name(), clientDTO.email(), clientDTO.fone());
        clientRepository.save(client);
        return client;
    }
}
