package com.ifsuldeminas.pas.bcc.gamestorewbe.controllers;

import com.ifsuldeminas.pas.bcc.gamestorewbe.entities.Cliente.Cliente;
import com.ifsuldeminas.pas.bcc.gamestorewbe.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "http://localhost:4200/clientes") // Para integrar com o front
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes(){
        List<Cliente> clientes = clienteService.listarClientes();
        return ResponseEntity.ok().body(clientes);
    }

    @PostMapping("/addLista")
    public ResponseEntity<List<Cliente>> addCliente(@RequestBody List<Cliente> clientes){
        for (Cliente cliente : clientes) {
            clienteService.addCliente(cliente);
        }
        return ResponseEntity.ok().body(clientes);
    }

    @PostMapping
    void addCliente(@RequestBody Cliente cliente){
        clienteService.addCliente(cliente);
        System.out.println("jogo salvo com sucesso!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizaCliente(@RequestBody Cliente cliente, @PathVariable Integer id ){
        Cliente clienteAtualizada = cliente;
        clienteAtualizada.setIdCliente(id);
        clienteService.atualizaCliente(clienteAtualizada);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> deletaCliente(@PathVariable Integer id){
        clienteService.deletaCliente(id);
        return ResponseEntity.noContent().build();
    }
}
