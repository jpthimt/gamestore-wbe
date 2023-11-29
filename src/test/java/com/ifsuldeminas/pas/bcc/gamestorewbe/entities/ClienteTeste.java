package com.ifsuldeminas.pas.bcc.gamestorewbe.entities;

import com.ifsuldeminas.pas.bcc.gamestorewbe.model.domain.cliente.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ClienteTeste {
    Cliente cliente = new Cliente();

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @BeforeEach
    void beforeEach() {
        cliente = new Cliente();
    }

    @Test
    void pessoaVazio(){
        assertNotNull(cliente);
    }

    @Test
    void setPessoa(){
        cliente = new Cliente("nome", "cpf", "email", LocalDate.of(2001,01,01), "telefone");
        assertNotNull(cliente.getNome());
        assertNotNull(cliente.getCpf());
        assertNotNull(cliente.getEmail());
        assertNotNull(cliente.getDataNasc());
        assertNotNull(cliente.getTelefone());
    }
}
