package com.ifsuldeminas.pas.bcc.gamestorewbe.controllers;

import com.ifsuldeminas.pas.bcc.gamestorewbe.entities.Produto.Jogo;
import com.ifsuldeminas.pas.bcc.gamestorewbe.repositories.JogoRepository;
import com.ifsuldeminas.pas.bcc.gamestorewbe.services.JogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jogos")
//@CrossOrigin(origins = "http://localhost:4200") // Para integrar com o front
public class JogoController {

    @Autowired
    private JogoService jogoService;

    @GetMapping
    public ResponseEntity<List<Jogo>> listarJogos(){
        List<Jogo> jogos = jogoService.listarJogos();
        return ResponseEntity.ok().body(jogos);
    }

    @PostMapping
    public ResponseEntity<List<Jogo>> addJogo(@RequestBody List<Jogo> jogos){
        for (Jogo jogo : jogos) {
            jogoService.addJogo(jogo);
        }
        return ResponseEntity.ok().body(jogos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Jogo> atualizaJogo(@RequestBody Jogo jogo, @PathVariable Integer id ){
        Jogo jogoAtualizado = jogo;
        jogoAtualizado.setIdJogo(id);
        jogoService.atualizaJogo(jogoAtualizado);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Jogo> deletaJogo(@PathVariable Integer id){
        jogoService.deletaJogo(id);
        return ResponseEntity.noContent().build();
    }
}