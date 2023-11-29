package com.ifsuldeminas.pas.bcc.gamestorewbe.entities;

import com.ifsuldeminas.pas.bcc.gamestorewbe.model.domain.compra.Item;
import com.ifsuldeminas.pas.bcc.gamestorewbe.model.domain.jogo.Jogo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.time.LocalDate;

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
        item = new Item(new Jogo("nome", LocalDate.of(2000,01,10), 1.0f, 1, 1.0f, "url"), 1);
        assertNotNull(item.getJogo());
        assertNotNull(item.getQuantidade());
        assertNotNull(item.getValorTotal());
    }
}
