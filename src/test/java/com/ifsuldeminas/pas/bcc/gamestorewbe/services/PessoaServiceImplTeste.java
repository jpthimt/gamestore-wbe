package com.ifsuldeminas.pas.bcc.gamestorewbe.services;

import com.ifsuldeminas.pas.bcc.gamestorewbe.entities.Pessoa.Pessoa;
import com.ifsuldeminas.pas.bcc.gamestorewbe.repositories.PessoaRepository;
import com.ifsuldeminas.pas.bcc.gamestorewbe.services.impl.PessoaServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class PessoaServiceImplTeste {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Autowired
    private PessoaServiceImpl pessoaService;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Test
    void listarPessoas(){
        assertNotNull(pessoaRepository.findAll());
    }

    @Test
    void buscarPessoaPorId(){
        assertNotNull(pessoaRepository.findById(1));
    }

    @Test
    void addPessoa(){
        Integer cont = pessoaService.listarPessoas().size();
        Pessoa p = new Pessoa("nome", "cpf", "email", LocalDate.parse("01/01/2001", formatter), "telefone");
        pessoaService.addPessoa(p);
        assertTrue(pessoaService.listarPessoas().size() > cont);
    }

    @Test
    void atualizarPessoa(){
        Pessoa p = new Pessoa("nome", "cpf", "email", LocalDate.parse("01/01/2001", formatter), "telefone");
        pessoaService.addPessoa(p);
        p.setNome("nome2");
        pessoaService.atualizaPessoa(p);
        assertTrue(pessoaService.listarPessoas().get(1).getNome().equals("nome2"));
    }

    @Test
    void deletaPessoa(){
        Pessoa p = new Pessoa("nome", "cpf", "email", LocalDate.parse("01/01/2001", formatter), "telefone");
        pessoaService.addPessoa(p);
        Integer cont = pessoaService.listarPessoas().size();
        pessoaService.deletaPessoa(p.getIdPessoa());
        assertTrue(pessoaService.listarPessoas().size() < cont);
    }
}
