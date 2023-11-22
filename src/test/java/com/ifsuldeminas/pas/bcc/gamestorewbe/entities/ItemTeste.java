package com.ifsuldeminas.pas.bcc.gamestorewbe.entities;

import com.ifsuldeminas.pas.bcc.gamestorewbe.entities.Compra.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ItemTeste {
    Item item = new Item();

    @BeforeEach
    void beforeEach() {
        item = new Item();
    }

    @Test
    void itemVazio(){
        assertNotNull(item);
    }

    @Test
    void setItem(){
        item = new Item(1, 1, 1.0f);
        assertNotNull(item.getIdProduto());
        assertNotNull(item.getQuantidade());
        assertNotNull(item.getValor());
    }
}
