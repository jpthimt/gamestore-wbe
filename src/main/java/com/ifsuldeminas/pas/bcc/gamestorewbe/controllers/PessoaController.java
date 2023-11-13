package com.ifsuldeminas.pas.bcc.gamestorewbe.controllers;

import com.ifsuldeminas.pas.bcc.gamestorewbe.entities.Pessoa.Pessoa;
import com.ifsuldeminas.pas.bcc.gamestorewbe.entities.Produto.Jogo;
import com.ifsuldeminas.pas.bcc.gamestorewbe.repositories.PessoaRepository;
import com.ifsuldeminas.pas.bcc.gamestorewbe.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
//CrossOrigin(origins = "http://localhost:4200") // Para integrar com o front
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public ResponseEntity<List<Pessoa>> listarPessoas(){
        List<Pessoa> pessoas = pessoaService.listarPessoas();
        return ResponseEntity.ok().body(pessoas);
    }

    @PostMapping
    public ResponseEntity<List<Pessoa>> addPessoa(@RequestBody List<Pessoa> pessoas){
        for (Pessoa pessoa : pessoas) {
            pessoaService.addPessoa(pessoa);
        }
        return ResponseEntity.ok().body(pessoas);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> atualizaPessoa(@RequestBody Pessoa pessoa, @PathVariable Integer id ){
        Pessoa pessoaAtualizada = pessoa;
        pessoaAtualizada.setIdPessoa(id);
        pessoaService.atualizaPessoa(pessoaAtualizada);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Pessoa> deletaPessoa(@PathVariable Integer id){
        pessoaService.deletaPessoa(id);
        return ResponseEntity.noContent().build();
    }
}
