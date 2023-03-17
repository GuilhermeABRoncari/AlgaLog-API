package com.algaworks.algalog.domain.service;

import com.algaworks.algalog.domain.dto.ClientDTO;
import com.algaworks.algalog.domain.dto.UpdateClientDTO;
import com.algaworks.algalog.domain.entity.Client;
import com.algaworks.algalog.domain.exception.EmailUsedExecption;
import com.algaworks.algalog.domain.exception.InvalidIdException;
import com.algaworks.algalog.domain.reposiotry.ClientRepository;
import com.algaworks.algalog.domain.response.ClientResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class ClientService {
    private ClientRepository clientRepository;

    @Transactional
    public ClientResponse save(ClientDTO clientDTO) {
        if (!clientRepository.existsByEmail(clientDTO.email())) {
            var client = new Client(null, clientDTO.name(), clientDTO.email(), clientDTO.fone());
            clientRepository.save(client);
            return new ClientResponse(client);
        } else throw new EmailUsedExecption("This email is already in use.");
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
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
        } else throw new EntityNotFoundException();
    }

    public ClientResponse find(Long id) {
        if (clientRepository.existsById(id)) {
            return new ClientResponse(clientRepository.getReferenceById(id));
        } else throw new InvalidIdException("Client not found.");
    }
}
