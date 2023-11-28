package com.ifsuldeminas.pas.bcc.gamestorewbe.model.repositories;


import com.ifsuldeminas.pas.bcc.gamestorewbe.model.domain.cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
