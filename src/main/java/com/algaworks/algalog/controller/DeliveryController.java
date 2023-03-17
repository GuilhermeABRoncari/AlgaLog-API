package com.algaworks.algalog.controller;

import com.algaworks.algalog.domain.dto.DeliveryDTO;
import com.algaworks.algalog.domain.entity.Delivery;
import com.algaworks.algalog.domain.service.DeliveryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/deliverys")
@AllArgsConstructor
public class DeliveryController {
    private DeliveryService deliveryService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Delivery request(@RequestBody DeliveryDTO deliveryDTO){
        return deliveryService.request(deliveryDTO);
    }
}
