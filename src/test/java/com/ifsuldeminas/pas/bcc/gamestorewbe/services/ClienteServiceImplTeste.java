package com.ifsuldeminas.pas.bcc.gamestorewbe.services;

import com.ifsuldeminas.pas.bcc.gamestorewbe.entities.Cliente.Cliente;
import com.ifsuldeminas.pas.bcc.gamestorewbe.repositories.ClienteRepository;
import com.ifsuldeminas.pas.bcc.gamestorewbe.services.impl.ClienteServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ClienteServiceImplTeste {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Autowired
    private ClienteServiceImpl clienteService;

    @Autowired
    private ClienteRepository clienteRepository;

    @Test
    void listarClientes(){
        assertNotNull(clienteRepository.findAll());
    }

    @Test
    void buscarClientePorId(){
        assertNotNull(clienteRepository.findById(1));
    }

    @Test
    void addCliente(){
        Integer cont = clienteService.listarClientes().size();
        Cliente p = new Cliente("nome", "cpf", "email", LocalDate.parse("01/01/2001", formatter), "telefone");
        clienteService.addCliente(p);
        assertTrue(clienteService.listarClientes().size() > cont);
    }

    @Test
    void atualizarCliente(){
        Cliente p = new Cliente("nome", "cpf", "email", LocalDate.parse("01/01/2001", formatter), "telefone");
        clienteService.addCliente(p);
        p.setNome("nome2");
        clienteService.atualizaCliente(p);
        assertTrue(clienteService.listarClientes().get(1).getNome().equals("nome2"));
    }

    @Test
    void deletaCliente(){
        Cliente p = new Cliente("nome", "cpf", "email", LocalDate.parse("01/01/2001", formatter), "telefone");
        clienteService.addCliente(p);
        Integer cont = clienteService.listarClientes().size();
        clienteService.deletaCliente(p.getIdCliente());
        assertTrue(clienteService.listarClientes().size() < cont);
    }
}
