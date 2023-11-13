package com.ifsuldeminas.pas.bcc.gamestorewbe.services.impl;

import com.ifsuldeminas.pas.bcc.gamestorewbe.entities.Produto.Jogo;
import com.ifsuldeminas.pas.bcc.gamestorewbe.repositories.JogoRepository;
import com.ifsuldeminas.pas.bcc.gamestorewbe.services.JogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JogoServiceImpl implements JogoService {

    @Autowired
    private JogoRepository jogoRepository;

    @Override
    public List<Jogo> listarJogos() {
        return jogoRepository.findAll();
    }
    @Override
    public Jogo buscarJogoPorId(Integer id) {
        Optional<Jogo> jogo = jogoRepository.findById(id);
        return jogo.orElse(null);
    }

    @Override
    public void addJogo(Jogo jogo) {
        jogo.setIdJogo(null);
        jogoRepository.save(jogo);
    }

    @Override
    public void atualizaJogo(Jogo jogo) {
        Jogo atual = this.buscarJogoPorId(jogo.getIdJogo());
        atual.setResponseName(jogo.getResponseName());
        atual.setReleaseDate(jogo.getReleaseDate());
        atual.setMetacritic(jogo.getMetacritic());
        atual.setRecommendationCount(jogo.getRecommendationCount());
        atual.setPriceInitial(jogo.getPriceInitial());
        atual.setImageURL(jogo.getImageURL());
        jogoRepository.save(atual);
    }

    @Override
    public void deletaJogo(Integer id) {
        jogoRepository.deleteById(id);
    }
}