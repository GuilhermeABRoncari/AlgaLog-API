package com.algaworks.algalog.domain.entity;

import com.algaworks.algalog.domain.exception.BusinessRuleException;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Delivery")
@Table(name = "deliverys")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    @OneToMany(mappedBy = "delivery", cascade = CascadeType.ALL)
    private List<Occurrence> occurrenceList = new ArrayList<>();
    @Embedded
    private Recipient recipient;
    private BigDecimal rate;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusDelivery statusDelivery;
    @Column(name = "orderdate")
    private OffsetDateTime orderDate;
    @Column(name = "finisheddate")
    private OffsetDateTime finishedDate;

    public Occurrence addOccurrence(String description) {
        Occurrence occurrence = new Occurrence();
        occurrence.setDelivery(this);
        occurrence.setDescription(description);
        occurrence.setRegistrationDate(OffsetDateTime.now());
        this.getOccurrenceList().add(occurrence);
        return occurrence;
    }

    public void finish() {
        if(this.statusDelivery.equals(statusDelivery.FINISHED)) throw new BusinessRuleException("This delivery is already finished.");
        if(!statusDelivery.PENDING.equals(this.statusDelivery)) throw new BusinessRuleException("Delivery cannot be completed.");

        setStatusDelivery(statusDelivery.FINISHED);
        setFinishedDate(OffsetDateTime.now());
    }
}
