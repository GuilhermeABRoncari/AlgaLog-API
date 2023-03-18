package com.algaworks.algalog.domain.dto;

import jakarta.validation.constraints.NotBlank;

public record OccurrenceDTO(@NotBlank String description) {
}
