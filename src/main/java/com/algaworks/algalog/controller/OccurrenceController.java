package com.algaworks.algalog.controller;

import com.algaworks.algalog.domain.dto.OccurrenceDTO;
import com.algaworks.algalog.domain.response.OccurrenceResponse;
import com.algaworks.algalog.domain.service.OccurrenceService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("deliverys/{delivery_id}/occurrences")
public class OccurrenceController {
    private OccurrenceService occurrenceService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OccurrenceResponse register(@PathVariable Long delivery_id, @RequestBody @Valid OccurrenceDTO occurrenceDTO) {
        return occurrenceService.register(delivery_id, occurrenceDTO.description());
    }
}

