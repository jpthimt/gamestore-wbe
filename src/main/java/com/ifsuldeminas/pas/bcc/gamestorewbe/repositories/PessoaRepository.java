package com.ifsuldeminas.pas.bcc.gamestorewbe.repositories;

import com.ifsuldeminas.pas.bcc.gamestorewbe.entities.Pessoa.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
}
