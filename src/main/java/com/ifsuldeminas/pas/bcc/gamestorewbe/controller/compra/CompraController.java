package com.ifsuldeminas.pas.bcc.gamestorewbe.controller.compra;


import com.ifsuldeminas.pas.bcc.gamestorewbe.model.domain.compra.Compra;
import com.ifsuldeminas.pas.bcc.gamestorewbe.model.domain.compra.Item;
import com.ifsuldeminas.pas.bcc.gamestorewbe.model.repositories.ClienteRepository;
import com.ifsuldeminas.pas.bcc.gamestorewbe.model.services.ClienteService;
import com.ifsuldeminas.pas.bcc.gamestorewbe.model.services.CompraService;
import com.ifsuldeminas.pas.bcc.gamestorewbe.model.services.ItemService;
import com.ifsuldeminas.pas.bcc.gamestorewbe.model.services.JogoService;
import com.ifsuldeminas.pas.bcc.gamestorewbe.model.services.impl.ItemServiceImpl;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compras")
public class CompraController {

    private static final Logger LOG = org.slf4j.LoggerFactory.getLogger(ItemServiceImpl.class);

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
