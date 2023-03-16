package com.algaworks.algalog.domain.service;

import com.algaworks.algalog.domain.dto.UpdateClientDTO;
import com.algaworks.algalog.domain.entity.Client;
import com.algaworks.algalog.domain.reposiotry.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.MethodArgumentNotValidException;

@Service
@AllArgsConstructor
public class ClientService {
    private ClientRepository clientRepository;

    @Transactional
    public Client save(Client client) {

        return clientRepository.save(client);
    }

    @Transactional
    public Client update(Long id, UpdateClientDTO updateClientDTO) {
        if (clientRepository.existsById(id)) {
            Client client = clientRepository.getReferenceById(id);
            client.update(updateClientDTO);
            return client;
        }
    }

    @Transactional
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

}
