package com.algaworks.algalog.domain.response;

import com.algaworks.algalog.domain.entity.Occurrence;

import java.time.OffsetDateTime;

public record OccurrenceResponse(Long id, String description, OffsetDateTime registrationDate) {
    public OccurrenceResponse(Occurrence occurrence) {
        this(occurrence.getId(), occurrence.getDescription(), occurrence.getRegistrationDate());
    }
}
