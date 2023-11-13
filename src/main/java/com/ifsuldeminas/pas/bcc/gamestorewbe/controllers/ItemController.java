package com.ifsuldeminas.pas.bcc.gamestorewbe.controllers;

import com.ifsuldeminas.pas.bcc.gamestorewbe.entities.Compra.Item;
import com.ifsuldeminas.pas.bcc.gamestorewbe.services.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itens")
public class ItemController {
    private ItemService itensService;

    @GetMapping
    public ResponseEntity<List<Item>> listarItem(){
        List<Item> itens = itensService.listarItem();
        return ResponseEntity.ok().body(itens);
    }

    @PostMapping
    public ResponseEntity<List<Item>> addItem(@RequestBody List<Item> itens){
        for (Item item : itens) {
            itensService.addItem(item);
        }
        return ResponseEntity.ok().body(itens);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> atualizaItem(@RequestBody Item item, @PathVariable Integer id ){
        Item itemAtualizado = item;
        itemAtualizado.setIdItem(id);
        itensService.atualizaItem(itemAtualizado);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Item> deletaItem(@PathVariable Integer id){
        itensService.deletaItem(id);
        return ResponseEntity.noContent().build();
    }
}
