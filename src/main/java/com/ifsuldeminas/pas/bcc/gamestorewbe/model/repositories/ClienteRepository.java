package com.ifsuldeminas.pas.bcc.gamestorewbe.repositories;

import com.ifsuldeminas.pas.bcc.gamestorewbe.entities.Cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
