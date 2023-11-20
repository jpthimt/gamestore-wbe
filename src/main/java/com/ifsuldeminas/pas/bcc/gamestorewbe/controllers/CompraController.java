package com.ifsuldeminas.pas.bcc.gamestorewbe.controllers;

import com.ifsuldeminas.pas.bcc.gamestorewbe.entities.Compra.Compra;
import com.ifsuldeminas.pas.bcc.gamestorewbe.services.CompraService;
import com.ifsuldeminas.pas.bcc.gamestorewbe.services.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compras")
public class CompraController {

    private CompraService compraService;
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Compra>> listarCompras(){
        List<Compra> compras = compraService.listarCompras();
        return ResponseEntity.ok().body(compras);
    }

    @PostMapping
    public ResponseEntity<List<Compra>> addCompra(@RequestBody List<Compra> compras){
        for (Compra compra : compras) {
            if (clienteService.buscarClientePorId(compra.getIdCliente()) == null)  // Verifica se a cliente existe
                return ResponseEntity.badRequest().build();
            compraService.addCompra(compra);
        }
        return ResponseEntity.ok().body(compras);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Compra> atualizaCompra(@RequestBody Compra compra, @PathVariable Integer id ){
        Compra compraAtualizada = compra;
        compraAtualizada.setIdCompra(id);
        if (clienteService.buscarClientePorId(compraAtualizada.getIdCliente()) == null)  // Verifica se a cliente existe
            return ResponseEntity.badRequest().build();
        compraService.atualizaCompra(compraAtualizada);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Compra> deletaCompra(@PathVariable Integer id){
        compraService.deletaCompra(id);
        return ResponseEntity.noContent().build();
    }
}
