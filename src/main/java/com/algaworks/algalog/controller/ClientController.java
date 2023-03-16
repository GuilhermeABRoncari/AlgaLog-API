package com.algaworks.algalog.controller;

import com.algaworks.algalog.domain.dto.ClientDTO;
import com.algaworks.algalog.domain.dto.UpdateClientDTO;
import com.algaworks.algalog.domain.entity.Client;
import com.algaworks.algalog.domain.reposiotry.ClientRepository;
import com.algaworks.algalog.domain.service.ClientService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/clients")
public class ClientController {
    private ClientRepository clientRepository;
    private ClientService clientService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Client> listClients() {
        return clientRepository.findAll().stream().toList();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Client> findClientById(@PathVariable Long id) {
        return clientRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client saveNewClient(@RequestBody @Valid ClientDTO clientDTO) {
        return clientService.save(new Client(null, clientDTO.name(), clientDTO.email(), clientDTO.fone()));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateClientById(@PathVariable Long id, @RequestBody @Valid UpdateClientDTO updateClientDTO) {
        var client = clientRepository.getReferenceById(id);
        client.update(updateClientDTO);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClientById(@PathVariable Long id) {
        clientService.delete(id);
    }
}
