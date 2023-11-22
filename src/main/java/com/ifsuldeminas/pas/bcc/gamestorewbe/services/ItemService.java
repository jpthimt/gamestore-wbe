package com.ifsuldeminas.pas.bcc.gamestorewbe.services;

import com.ifsuldeminas.pas.bcc.gamestorewbe.entities.Compra.Item;

import java.util.List;

public interface ItemService {

    List<Item> listarItem();
    Item buscarItemPorId(Integer id);
    void addItem(Item item);
    void atualizaItem(Item item);
    void deletaItem(Integer id);
    Float calculaValorTotal(Item item);
    Float calculaValorUnid(Item item);
    boolean verificaJogo(Item item);
}
