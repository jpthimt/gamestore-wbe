package com.ifsuldeminas.pas.bcc.gamestorewbe.services;

import com.ifsuldeminas.pas.bcc.gamestorewbe.entities.Compra.Item;
import com.ifsuldeminas.pas.bcc.gamestorewbe.repositories.ItemRepository;
import com.ifsuldeminas.pas.bcc.gamestorewbe.services.impl.ItemServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;

@SpringBootTest
public class ItemServiceImplTeste {
    @Autowired
    private ItemServiceImpl itemService;
    @Autowired
    private ItemRepository itemRepository;

     @Test
    void listarItens(){
         assertNotNull(itemRepository.findAll());
     }

     @Test
    void buscarItemPorId(){
         assertNotNull(itemRepository.findById(1));
     }

     @Test
    void addItem(){
         Integer cont = itemService.listarItem().size();
         Item item = new Item(1, 1, 1, 1.0f);
         itemService.addItem(item);
         assertNotNull(itemService.listarItem().size() > cont);
     }

     @Test
    void atualizarItem(){
         Item item = new Item(1, 1, 1, 1.0f);
         itemService.addItem(item);
         item.setIdCompra(2);
         itemService.atualizaItem(item);
         assertNotNull(itemService.listarItem().get(0).getIdCompra().equals(2));
     }

     @Test
    void removeItem(){
         Item item = new Item(1, 1, 1, 1.0f);
         itemService.addItem(item);
         Integer cont = itemService.listarItem().size();
         itemService.deletaItem(1);
         assertNotNull(itemService.listarItem().size() < cont);
     }
}
