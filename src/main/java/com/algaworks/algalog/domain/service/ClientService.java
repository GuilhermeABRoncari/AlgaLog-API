package com.algaworks.algalog.domain.service;

import com.algaworks.algalog.domain.dto.ClientDTO;
import com.algaworks.algalog.domain.dto.UpdateClientDTO;
import com.algaworks.algalog.domain.entity.Client;
import com.algaworks.algalog.domain.reposiotry.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class ClientService {
    private ClientRepository clientRepository;

    @Transactional
    public Client save(ClientDTO client) {
        return clientRepository.save(new Client(null, client.name(), client.email(), client.fone()));
    }

    @Transactional
    public Client update(Long id, UpdateClientDTO updateClientDTO) {
        if (clientRepository.existsById(id)) {
            Client client = clientRepository.getReferenceById(id);
            client.update(updateClientDTO);
            return client;
        }
        throw new EntityNotFoundException();
    }

    @Transactional
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

}
