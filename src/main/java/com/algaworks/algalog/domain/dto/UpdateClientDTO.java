package com.algaworks.algalog.domain.dto;

import jakarta.validation.constraints.Email;

public record UpdateClientDTO (
        String name,
        @Email(message = "{message-02}")
        String email,
        String fone){
}
