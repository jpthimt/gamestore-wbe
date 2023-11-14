package com.ifsuldeminas.pas.bcc.gamestorewbe.entities;

import com.ifsuldeminas.pas.bcc.gamestorewbe.entities.Produto.Jogo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class JogoTeste {
    Jogo jogo = new Jogo();

    @BeforeEach
    void beforeEach() {
        jogo = new Jogo();
    }

    @Test
    void jogoVazio(){
        assertNotNull(jogo);
    }

    @Test
    void setJogo(){
        jogo = new Jogo("nome", LocalDate.of(2000,01,10), 1.0f, 1, 1.0f, "url");
        assertNotNull(jogo.getIdJogo());
        assertNotNull(jogo.getResponseName());
        assertNotNull(jogo.getReleaseDate());
        assertNotNull(jogo.getMetacritic());
        assertNotNull(jogo.getRecommendationCount());
        assertNotNull(jogo.getPriceInitial());
        assertNotNull(jogo.getImageURL());
    }
}
