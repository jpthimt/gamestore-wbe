package com.ifsuldeminas.pas.bcc.gamestorewbe.entities;

import com.ifsuldeminas.pas.bcc.gamestorewbe.entities.Compra.Compra;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CompraTeste {
    Compra compra = new Compra();

    @BeforeEach
    void beforeEach() {
        compra = new Compra();
    }

    @Test
    void compraVazio(){
        assertNotNull(compra);
    }

    @Test
    void setCompra(){
        compra = new Compra(1, 1.0f);
        assertNotNull(compra.getIdCliente());
        assertNotNull(compra.getValorTotal());
    }

}
