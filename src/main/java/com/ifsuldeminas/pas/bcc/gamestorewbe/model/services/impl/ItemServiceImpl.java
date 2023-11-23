package com.ifsuldeminas.pas.bcc.gamestorewbe.services.impl;

import com.ifsuldeminas.pas.bcc.gamestorewbe.entities.Compra.Item;
import com.ifsuldeminas.pas.bcc.gamestorewbe.repositories.ItemRepository;
import com.ifsuldeminas.pas.bcc.gamestorewbe.services.ItemService;
import com.ifsuldeminas.pas.bcc.gamestorewbe.services.JogoService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

    private static final Logger LOG = org.slf4j.LoggerFactory.getLogger(ItemServiceImpl.class);

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private JogoService jogoService;

    @Override
    public List<Item> listarItem() {
        return itemRepository.findAll();
    }
    @Override
    public Item buscarItemPorId(Integer id) {
        Optional<Item> item = itemRepository.findById(id);
        return item.orElse(null);
    }

    @Override
    public void addItem(Item item) {
        item.setIdItem(null);
        itemRepository.save(item);
    }
    @Override
    public void atualizaItem(Item item) {
        Item atual = this.buscarItemPorId(item.getIdItem());
        atual.setJogo(item.getJogo());
        atual.setQuantidade(item.getQuantidade());
        atual.setValorUnid(calculaValorUnid(item));
        atual.setValorTotal(calculaValorTotal(item));
        itemRepository.save(atual);
    }

    @Override
    public void deletaItem(Integer id) {
        itemRepository.deleteById(id);
    }

    @Override
    public Float calculaValorTotal(Item item) {

        return item.getValor()*item.getQuantidade();
    }

    @Override
    public Float calculaValorUnid(Item item) {
        return jogoService.buscarJogoPorId(item.getJogo().getIdJogo()).getPriceInitial();
    }

    @Override
    public boolean verificaJogo(Item item) {
        if (jogoService.buscarJogoPorId(item.getJogo().getIdJogo()) == null){  // Verifica se o jogo existe
            ResponseEntity.badRequest().build();
            LOG.error("Jogo não existe!");
            return true;
        }
        LOG.info("Jogo existe!");
        return false;
    }


}
