package com.algaworks.algalog.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "Delivery")
@Table(name = "deliverys")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
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
    private LocalDateTime orderDate;
    @Column(name = "finisheddate")
    private LocalDateTime finishedDate;

}
