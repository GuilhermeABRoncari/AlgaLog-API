package com.algaworks.algalog.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Embeddable
public class Recipient {
    @NotBlank
    @Column(name = "recipient_name")
    private String name;
    @NotBlank
    @Column(name = "recipient_street")
    private String street;
    @NotBlank
    @Column(name = "recipient_number")
    private String number;
    @Column(name = "recipient_complement")
    private String complement;
    @NotBlank
    @Column(name = "recipient_neighborhood")
    private String neighborhood;
}
