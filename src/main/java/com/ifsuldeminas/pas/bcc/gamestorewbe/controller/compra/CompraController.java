package com.ifsuldeminas.pas.bcc.gamestorewbe.controller.compra;


import com.ifsuldeminas.pas.bcc.gamestorewbe.model.domain.compra.Compra;
import com.ifsuldeminas.pas.bcc.gamestorewbe.model.services.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compras")
public class CompraController {

    @Autowired
    private CompraService compraService;

    @GetMapping
    public ResponseEntity<List<Compra>> listarCompras() {
        List<Compra> compras = compraService.listarCompras();
        return ResponseEntity.ok().body(compras);
    }

    @PostMapping
    public ResponseEntity<Compra> addCompra(@RequestBody Compra compra) {
        compraService.addCompra(compra);
        return ResponseEntity.ok().body(compra);
    }

    @PostMapping("/addLista")
    public ResponseEntity<List<Compra>> addCompra(@RequestBody List<Compra> compras) {
        for (Compra compra : compras){
            compraService.addCompra(compra);
        }
        return ResponseEntity.ok().body(compras);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Compra> atualizaCompra(@RequestBody Compra compra, @PathVariable Integer id) {
        compraService.atualizaCompra(compra, id);
        return ResponseEntity.ok().body(compra);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Compra> deletaCompra(@PathVariable Integer id) {
        compraService.deletaCompra(id);
        return ResponseEntity.noContent().build();
    }
}
