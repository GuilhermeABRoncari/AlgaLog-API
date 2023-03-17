package com.algaworks.algalog.domain.dto;

import com.algaworks.algalog.domain.entity.Recipient;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record DeliveryDTO(
        @NotNull
        Long client_id,
        @Valid
        Recipient recipient,
        @NotNull
        BigDecimal rate) {
}
