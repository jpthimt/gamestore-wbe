package com.ifsuldeminas.pas.bcc.gamestorewbe.services;

import com.ifsuldeminas.pas.bcc.gamestorewbe.entities.Compra.Item;

import java.util.List;

public interface ItemService {

    public List<Item> listarItem();
    public Item buscarItemPorId(Integer id);
    public void addItem(Item item);
    public void atualizaItem(Item item);
    public void deletaItem(Integer id);
}
