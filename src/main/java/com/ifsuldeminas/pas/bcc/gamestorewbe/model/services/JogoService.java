package com.ifsuldeminas.pas.bcc.gamestorewbe.model.services;

import com.ifsuldeminas.pas.bcc.gamestorewbe.model.domain.jogo.Jogo;

import java.util.List;

public interface JogoService {
    List<Jogo> listarJogos();
    Jogo buscarJogoPorId(Integer id);
    void addJogo(Jogo jogo);
    void atualizaJogo(Jogo jogo);
    void deletaJogo(Integer id);
}