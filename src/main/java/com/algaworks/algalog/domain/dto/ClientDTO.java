package com.algaworks.algalog.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ClientDTO(
        Long id,
        @NotBlank(message = "{message-01}")
        String name,
        @Email(message = "{message-02}")
        @NotBlank(message = "{message-01}")
        String email,
        String fone) {
}
