package com.algaworks.algalog.domain.response;

import com.algaworks.algalog.domain.entity.Client;
import com.algaworks.algalog.domain.entity.Delivery;
import com.algaworks.algalog.domain.entity.Recipient;
import com.algaworks.algalog.domain.entity.StatusDelivery;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record DeliveryResponse(Long id, Client client, Recipient recipient, BigDecimal rate,
                               StatusDelivery statusDelivery, OffsetDateTime orderDate, OffsetDateTime finishedDate) {
    public DeliveryResponse(Delivery delivery) {
        this(delivery.getId(), delivery.getClient(), delivery.getRecipient(), delivery.getRate(),
                delivery.getStatusDelivery(), delivery.getOrderDate(), delivery.getFinishedDate());
    }
}
