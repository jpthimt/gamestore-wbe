package com.ifsuldeminas.pas.bcc.gamestorewbe.controllers;

import com.ifsuldeminas.pas.bcc.gamestorewbe.entities.Compra.Item;
import com.ifsuldeminas.pas.bcc.gamestorewbe.services.CompraService;
import com.ifsuldeminas.pas.bcc.gamestorewbe.services.ItemService;
import com.ifsuldeminas.pas.bcc.gamestorewbe.services.JogoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itens")
public class ItemController {
    private ItemService itensService;
    private JogoService jogoService;
    private CompraService compraService;

    @GetMapping
    public ResponseEntity<List<Item>> listarItem(){
        List<Item> itens = itensService.listarItem();
        return ResponseEntity.ok().body(itens);
    }

    @PostMapping
    public ResponseEntity<List<Item>> addItem(@RequestBody List<Item> itens){
        for (Item item : itens) {
            if (jogoService.buscarJogoPorId(item.getIdProduto()) == null)  // Verifica se o jogo existe
                return ResponseEntity.badRequest().build();
            if (compraService.buscarCompraPorId(item.getIdCompra()) == null)  // Verifica se a compra existe
                return ResponseEntity.badRequest().build();
            itensService.addItem(item);
        }
        return ResponseEntity.ok().body(itens);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> atualizaItem(@RequestBody Item item, @PathVariable Integer id ){
        Item itemAtualizado = item;
        itemAtualizado.setIdItem(id);
        if (jogoService.buscarJogoPorId(itemAtualizado.getIdProduto()) == null)  // Verifica se o jogo existe
            return ResponseEntity.badRequest().build();
        if (compraService.buscarCompraPorId(itemAtualizado.getIdCompra()) == null)  // Verifica se a compra existe
            return ResponseEntity.badRequest().build();
        itensService.atualizaItem(itemAtualizado);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Item> deletaItem(@PathVariable Integer id){
        itensService.deletaItem(id);
        return ResponseEntity.noContent().build();
    }
}
