package com.algaworks.algalog.domain.entity;

import com.algaworks.algalog.domain.dto.UpdateClientDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Entity(name = "Client")
@Table(name = "clients")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@EqualsAndHashCode(of = "id")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String fone;

    public void update(UpdateClientDTO updateClientDTO) {
        if (updateClientDTO.name() != null) this.name = updateClientDTO.name();
        if (updateClientDTO.email() != null) this.email = updateClientDTO.email();
        if (updateClientDTO.fone() != null) this.fone = updateClientDTO.fone();
    }
}


