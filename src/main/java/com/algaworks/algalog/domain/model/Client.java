package com.algaworks.algalog.domain.model;

import jakarta.persistence.*;
import lombok.*;
@Entity(name = "Client")
@Table(name = "clients")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String fone;
}
