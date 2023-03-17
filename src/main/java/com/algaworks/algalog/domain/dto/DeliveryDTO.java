package com.algaworks.algalog.domain.dto;

import com.algaworks.algalog.domain.entity.Recipient;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;

public record DeliveryDTO(
        @NotNull
        Long client_id,
        Recipient recipient,
        BigDecimal rate) {
}
