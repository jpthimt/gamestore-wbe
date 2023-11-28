package com.ifsuldeminas.pas.bcc.gamestorewbe.model.repositories;


import com.ifsuldeminas.pas.bcc.gamestorewbe.model.domain.compra.Compra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompraRepository extends JpaRepository<Compra, Integer> {
}
