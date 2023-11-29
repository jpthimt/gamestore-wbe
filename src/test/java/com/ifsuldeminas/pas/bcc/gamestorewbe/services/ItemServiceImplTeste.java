package com.ifsuldeminas.pas.bcc.gamestorewbe.services;

import com.ifsuldeminas.pas.bcc.gamestorewbe.model.domain.compra.Item;
import com.ifsuldeminas.pas.bcc.gamestorewbe.model.domain.jogo.Jogo;
import com.ifsuldeminas.pas.bcc.gamestorewbe.model.repositories.ItemRepository;
import com.ifsuldeminas.pas.bcc.gamestorewbe.model.services.impl.ItemServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;

@SpringBootTest
public class ItemServiceImplTeste {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
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
    void atualizarItem(){
         Item item = new Item(new Jogo("nome", LocalDate.parse("01/01/2001", formatter), 1.0f, 1, 1.0f, "url"), 1);
         itemService.addItem(item);
         item.setQuantidade(1);
         itemService.atualizaItem(item);
         assertNotNull(itemService.buscarItemPorId(item.getIdItem()).getQuantidade().equals(1));
     }

     @Test
    void removeItem(){
         Item item = new Item(new Jogo("nome", LocalDate.parse("01/01/2001", formatter), 1.0f, 1, 1.0f, "url"), 1);
         itemService.addItem(item);
         Integer cont = itemService.listarItem().size();
         itemService.deletaItem(1);
         assertNotNull(itemService.listarItem().size() < cont);
     }
}
