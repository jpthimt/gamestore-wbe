package com.ifsuldeminas.pas.bcc.gamestorewbe.model.repositories;


import com.ifsuldeminas.pas.bcc.gamestorewbe.model.domain.jogo.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogoRepository extends JpaRepository<Jogo, Integer> {

}