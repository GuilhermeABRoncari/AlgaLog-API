package com.algaworks.algalog.domain.response;

import com.algaworks.algalog.domain.entity.Client;

public record ClientResponse (Long id, String name, String email, String fone) {
    public ClientResponse (Client client) {
        this(client.getId(), client.getName(), client.getEmail(), client.getFone());
    }
}
