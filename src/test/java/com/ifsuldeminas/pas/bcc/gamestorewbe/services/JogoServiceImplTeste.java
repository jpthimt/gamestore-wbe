package com.ifsuldeminas.pas.bcc.gamestorewbe.services;

import com.ifsuldeminas.pas.bcc.gamestorewbe.entities.Produto.Jogo;
import com.ifsuldeminas.pas.bcc.gamestorewbe.repositories.JogoRepository;
import com.ifsuldeminas.pas.bcc.gamestorewbe.services.impl.JogoServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class JogoServiceImplTeste {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    @Autowired
    private JogoServiceImpl jogoService;
    @Autowired
    private JogoRepository jogoRepository;

    @Test
    void listarJogos(){
        assertNotNull(jogoRepository.findAll());
    }

    @Test
    void buscarJogoPorId(){
        assertNotNull(jogoRepository.findById(1));
    }

    @Test
    void addJogo(){
        Integer cont = jogoService.listarJogos().size();
        Jogo jogo = new Jogo("nome", LocalDate.parse("01/01/2001", formatter), 1.0f, 1, 1.0f, "url");
        jogoService.addJogo(jogo);
        assertNotNull(jogoService.listarJogos().size() > cont);
    }

    @Test
    void atualizarJogo(){
        Jogo jogo = new Jogo("nome", LocalDate.parse("01/01/2001", formatter), 1.0f, 1, 1.0f, "url");
        jogoService.addJogo(jogo);
        jogo.setResponseName("nome2");
        jogoService.atualizaJogo(jogo);
        assertNotNull(jogoService.listarJogos().get(0).getResponseName().equals("nome2"));
    }

    @Test
    void removeJogo(){
        Jogo jogo = new Jogo("nome", LocalDate.parse("01/01/2001", formatter), 1.0f, 1, 1.0f, "url");
        jogoService.addJogo(jogo);
        Integer cont = jogoService.listarJogos().size();
        jogoService.deletaJogo(1);
        assertTrue(jogoService.listarJogos().size() < cont);
    }
}
