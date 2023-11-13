package com.ifsuldeminas.pas.bcc.gamestorewbe.services.impl;

import com.ifsuldeminas.pas.bcc.gamestorewbe.entities.Compra.Item;
import com.ifsuldeminas.pas.bcc.gamestorewbe.repositories.ItemRepository;
import com.ifsuldeminas.pas.bcc.gamestorewbe.services.ItemService;

import java.util.List;
import java.util.Optional;

public class ItemServiceImpl implements ItemService {

    private ItemRepository itemRepository;

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
        atual.setIdCompra(item.getIdCompra());
        atual.setIdProduto(item.getIdProduto());
        atual.setQuantidade(item.getQuantidade());
        atual.setValor(item.getValor());
        itemRepository.save(atual);
    }

    @Override
    public void deletaItem(Integer id) {
        itemRepository.deleteById(id);
    }

}
