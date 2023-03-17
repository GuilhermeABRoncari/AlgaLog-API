package com.algaworks.algalog.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

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

}
