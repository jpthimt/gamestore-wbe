package com.ifsuldeminas.pas.bcc.gamestorewbe.model.services;

import com.ifsuldeminas.pas.bcc.gamestorewbe.model.domain.jogo.Jogo;

import java.util.List;

public interface JogoService {
    public List<Jogo> listarJogos();
    public Jogo buscarJogoPorId(Integer id);
    public void addJogo(Jogo jogo);
    public void atualizaJogo(Jogo jogo);
    public void deletaJogo(Integer id);
}