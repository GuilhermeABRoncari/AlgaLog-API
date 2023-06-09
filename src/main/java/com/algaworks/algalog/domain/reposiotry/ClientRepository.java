package com.algaworks.algalog.domain.reposiotry;

import com.algaworks.algalog.domain.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    boolean existsByEmail(String email);
}
