package com.ifsuldeminas.pas.bcc.gamestorewbe.services;

import com.ifsuldeminas.pas.bcc.gamestorewbe.entities.Produto.Jogo;

import java.util.List;

public interface JogoService {
    public List<Jogo> listarJogos();
    public Jogo buscarParticipantePorId(Integer id);
    public void addJogo(Jogo jogo);
    public void atualizaJogo(Jogo jogo);
    public void deletaJogo(Integer id);
}