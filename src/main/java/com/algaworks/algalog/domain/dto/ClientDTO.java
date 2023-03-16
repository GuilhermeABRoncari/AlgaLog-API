package com.algaworks.algalog.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ClientDTO(
        @NotBlank(message = "{message-01}")
        String name,
        @Email(message = "{message-02}")
        @NotBlank(message = "{message-01}")
        String email,
        @NotBlank(message = "{message-01}")
        @Size(max = 20)
        String fone) {

}
