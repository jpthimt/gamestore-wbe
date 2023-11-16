package com.ifsuldeminas.pas.bcc.gamestorewbe.entities;

import com.ifsuldeminas.pas.bcc.gamestorewbe.entities.Pessoa.Pessoa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import javax.xml.crypto.Data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PessoaTeste {
    Pessoa pessoa = new Pessoa();

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @BeforeEach
    void beforeEach() {
        pessoa = new Pessoa();
    }

    @Test
    void pessoaVazio(){
        assertNotNull(pessoa);
    }

    @Test
    void setPessoa(){
        pessoa = new Pessoa("nome", "cpf", "email", LocalDate.of(2001,01,01), "telefone");
        assertNotNull(pessoa.getNome());
        assertNotNull(pessoa.getCpf());
        assertNotNull(pessoa.getEmail());
        assertNotNull(pessoa.getDataNasc());
        assertNotNull(pessoa.getTelefone());
    }
}
