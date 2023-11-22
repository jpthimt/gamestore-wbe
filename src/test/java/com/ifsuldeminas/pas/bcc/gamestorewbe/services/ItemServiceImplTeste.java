package com.ifsuldeminas.pas.bcc.gamestorewbe.services;

import com.ifsuldeminas.pas.bcc.gamestorewbe.entities.Compra.Compra;
import com.ifsuldeminas.pas.bcc.gamestorewbe.entities.Compra.Item;
import com.ifsuldeminas.pas.bcc.gamestorewbe.entities.Jogo.Jogo;
import com.ifsuldeminas.pas.bcc.gamestorewbe.repositories.ItemRepository;
import com.ifsuldeminas.pas.bcc.gamestorewbe.services.impl.CompraServiceImpl;
import com.ifsuldeminas.pas.bcc.gamestorewbe.services.impl.ItemServiceImpl;
import com.ifsuldeminas.pas.bcc.gamestorewbe.services.impl.JogoServiceImpl;
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
    @Autowired
    private CompraServiceImpl compraService;
    @Autowired
    private JogoServiceImpl jogoService;

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
         Jogo jogo = new Jogo("nome", LocalDate.parse("01/01/2001", formatter), 1.0f, 1, 1.0f, "url");
         jogoService.addJogo(jogo);
         Compra compra = new Compra(1, 1.0f);
         compraService.addCompra(compra);
         Item item = new Item(1, 1, 1, 1.0f);
         itemService.addItem(item);
         Integer cont = itemService.listarItem().size();
         Jogo jogo2 = new Jogo("nome", LocalDate.parse("01/01/2001", formatter), 1.0f, 1, 1.0f, "url");
         jogoService.addJogo(jogo);
         Compra compra2 = new Compra(1, 1.0f);
         compraService.addCompra(compra);
         Item item2 = new Item(1, 1, 1, 1.0f);
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
