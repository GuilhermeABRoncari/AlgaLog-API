package com.algaworks.algalog.controller;

import com.algaworks.algalog.domain.dto.DeliveryDTO;
import com.algaworks.algalog.domain.entity.Delivery;
import com.algaworks.algalog.domain.reposiotry.DeliveryRepository;
import com.algaworks.algalog.domain.response.DeliveryResponse;
import com.algaworks.algalog.domain.service.DeliveryService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/deliverys")
@AllArgsConstructor
public class DeliveryController {
    private DeliveryRepository deliveryRepository;
    private DeliveryService deliveryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Delivery request(@RequestBody @Valid DeliveryDTO deliveryDTO) {
        return deliveryService.request(deliveryDTO);
    }

    @GetMapping
    public Page<DeliveryResponse> findAll(Pageable pageable) {
        return deliveryService.page(pageable);
    }

    @GetMapping("{id}")
    public ResponseEntity<DeliveryResponse> findById(@PathVariable Long id) {
        return deliveryService.find(id);
    }
    @PutMapping("{id}/finish")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void finish(@PathVariable Long id) {
        deliveryService.finish(id);
    }
}
