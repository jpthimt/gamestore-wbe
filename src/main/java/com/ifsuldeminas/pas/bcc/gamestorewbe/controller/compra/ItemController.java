package com.ifsuldeminas.pas.bcc.gamestorewbe.controller.compra;


import com.ifsuldeminas.pas.bcc.gamestorewbe.model.domain.compra.Item;
import com.ifsuldeminas.pas.bcc.gamestorewbe.model.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itens")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping
    public ResponseEntity<List<Item>> listarItem(){
        List<Item> itens = itemService.listarItem();
        return ResponseEntity.ok().body(itens);
    }

    @PostMapping
    public ResponseEntity<List<Item>> addItem(@RequestBody List<Item> itens){
        for (Item item : itens) {
//            if (itemService.verificaJogo(item))  // Verifica se o jogo existe
//                return ResponseEntity.badRequest().build();
            itemService.addItem(item);
        }
        return ResponseEntity.ok().body(itens);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> atualizaItem(@RequestBody Item item, @PathVariable Integer id ){
        Item itemAtualizado = item;
        itemAtualizado.setIdItem(id);
//        if (itemService.verificaJogo(item))  // Verifica se o jogo existe
//            return ResponseEntity.badRequest().build();
        itemService.atualizaItem(itemAtualizado);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Item> deletaItem(@PathVariable Integer id){
        itemService.deletaItem(id);
        return ResponseEntity.noContent().build();
    }
}
