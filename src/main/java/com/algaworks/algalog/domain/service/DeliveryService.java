package com.algaworks.algalog.domain.service;

import com.algaworks.algalog.domain.dto.DeliveryDTO;
import com.algaworks.algalog.domain.entity.Delivery;
import com.algaworks.algalog.domain.entity.Occurrence;
import com.algaworks.algalog.domain.entity.StatusDelivery;
import com.algaworks.algalog.domain.exception.BusinessRuleException;
import com.algaworks.algalog.domain.exception.InvalidIdException;
import com.algaworks.algalog.domain.exception.NotFoundIdException;
import com.algaworks.algalog.domain.reposiotry.ClientRepository;
import com.algaworks.algalog.domain.reposiotry.DeliveryRepository;
import com.algaworks.algalog.domain.response.DeliveryResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.List;

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
                    (List<Occurrence>) new Occurrence(),
                    deliveryDTO.recipient(), deliveryDTO.rate(),
                    StatusDelivery.PENDING,
                    OffsetDateTime.now(),
                    null);

            return deliveryRepository.save(delivery);
        } else throw new InvalidIdException("Client not found.");
    }

    public ResponseEntity<DeliveryResponse> find(Long id) {
        return ResponseEntity.ok(deliveryRepository.findById(id)
                .map(delivery -> new DeliveryResponse(delivery)).orElseThrow(() -> new InvalidIdException("Delivery not found.")));
    }

    public Page<DeliveryResponse> page(Pageable pageable) {
        Page<Delivery> all = deliveryRepository.findAll(pageable);
        Page<DeliveryResponse> page = all.map(delivery -> new DeliveryResponse(delivery));
        return page;
    }
    @Transactional
    public void finish(Long id){
        if(deliveryRepository.existsById(id)) {
            deliveryRepository.getReferenceById(id).finish();
        }else throw new NotFoundIdException("Delivery not found.");
    }
}
