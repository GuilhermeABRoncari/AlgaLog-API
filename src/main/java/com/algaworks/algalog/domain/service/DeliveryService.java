package com.algaworks.algalog.domain.service;

import com.algaworks.algalog.domain.dto.DeliveryDTO;
import com.algaworks.algalog.domain.entity.Delivery;
import com.algaworks.algalog.domain.entity.StatusDelivery;
import com.algaworks.algalog.domain.exception.InvalidClientException;
import com.algaworks.algalog.domain.reposiotry.ClientRepository;
import com.algaworks.algalog.domain.reposiotry.DeliveryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class DeliveryService {
    private DeliveryRepository deliveryRepository;
    private ClientRepository clientRepository;

    @Transactional
    public Delivery request(DeliveryDTO deliveryDTO) {
        if (clientRepository.existsById(deliveryDTO.client_id())) {

            Delivery delivery = new Delivery(null,
                    clientRepository.getReferenceById(deliveryDTO.client_id()),
                    deliveryDTO.recipient(), deliveryDTO.rate(),
                    StatusDelivery.PENDING,
                    LocalDateTime.now(),
                    null);

            return deliveryRepository.save(delivery);
        }else throw new InvalidClientException("Client not found.");
    }
}
