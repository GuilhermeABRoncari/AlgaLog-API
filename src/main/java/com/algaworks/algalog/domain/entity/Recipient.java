package com.algaworks.algalog.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestBody;

@Data
@Embeddable
@NotBlank
public class Recipient {
    @Column(name = "recipient_name")
    private String name;
    @Column(name = "recipient_street")
    private String street;
    @Column(name = "recipient_number")
    private String number;
    @Column(name = "recipient_complement")
    private String complement;
    @Column(name = "recipient_neighborhood")
    private String neighborhood;
}
