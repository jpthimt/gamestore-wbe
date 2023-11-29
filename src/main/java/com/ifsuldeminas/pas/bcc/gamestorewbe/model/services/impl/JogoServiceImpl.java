package com.ifsuldeminas.pas.bcc.gamestorewbe.model.services.impl;

import com.ifsuldeminas.pas.bcc.gamestorewbe.model.domain.jogo.Jogo;
import com.ifsuldeminas.pas.bcc.gamestorewbe.model.exceptions.jogo.JogoNotFoundException;
import com.ifsuldeminas.pas.bcc.gamestorewbe.model.repositories.JogoRepository;
import com.ifsuldeminas.pas.bcc.gamestorewbe.model.services.JogoService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JogoServiceImpl implements JogoService {

    private static final Logger LOG = org.slf4j.LoggerFactory.getLogger(JogoServiceImpl.class);

    @Autowired
    private JogoRepository jogoRepository;

    @Override
    public List<Jogo> listarJogos() {
        return jogoRepository.findAll();
    }
    @Override
    public Jogo buscarJogoPorId(Integer id) throws JogoNotFoundException{
        Optional<Jogo> jogo = jogoRepository.findById(id);
        return jogo.orElse(null);
    }

    @Override
    public void addJogo(Jogo jogo) {
        jogo.setIdJogo(null);
        jogoRepository.save(jogo);
        LOG.info("Jogo adicionado com sucesso");
    }

    @Override
    public void atualizaJogo(Jogo jogo) throws JogoNotFoundException{
        if (!this.jogoRepository.existsById(jogo.getIdJogo())){
            throw new JogoNotFoundException(jogo.getIdJogo());
        }
        Jogo atual = this.buscarJogoPorId(jogo.getIdJogo());
        atual.setResponseName(jogo.getResponseName());
        atual.setReleaseDate(jogo.getReleaseDate());
        atual.setMetacritic(jogo.getMetacritic());
        atual.setRecommendationCount(jogo.getRecommendationCount());
        atual.setPriceInitial(jogo.getPriceInitial());
        atual.setImageUrl(jogo.getImageUrl());
        jogoRepository.save(atual);
        LOG.info("Jogo atualizado com sucesso");
    }

    @Override
    public void deletaJogo(Integer id) throws JogoNotFoundException {
        if (!this.jogoRepository.existsById(id)){
            throw new JogoNotFoundException(id);
        }
        jogoRepository.deleteById(id);
        LOG.info("Jogo deletado com sucesso");
    }
}