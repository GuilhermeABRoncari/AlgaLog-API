package com.algaworks.algalog.controller;

import com.algaworks.algalog.domain.dto.ClientDTO;
import com.algaworks.algalog.domain.dto.UpdateClientDTO;
import com.algaworks.algalog.domain.entity.Client;
import com.algaworks.algalog.domain.reposiotry.ClientRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
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
    public List<Client> listClients() {
        return clientRepository.findAll().stream().toList();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Client find(@PathVariable Long id) {
        return clientRepository.getReferenceById(id);
    }

    @PostMapping
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    public Client save(@RequestBody @Valid ClientDTO clientDTO) {
        var client = new Client(null, clientDTO.name(), clientDTO.email(), clientDTO.fone());
        clientRepository.save(client);
        return client;
    }

    @PutMapping("{id}")
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Long id, @RequestBody UpdateClientDTO updateClientDTO) {
        var client = clientRepository.getReferenceById(id);
        client.update(updateClientDTO);
    }

    @DeleteMapping("{id}")
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        clientRepository.deleteById(id);
    }
}
