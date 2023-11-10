package com.ifsuldeminas.pas.bcc.gamestorewbe.repositories;

import com.ifsuldeminas.pas.bcc.gamestorewbe.entities.Produto.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogoRepository extends JpaRepository<Jogo, Integer> {

}