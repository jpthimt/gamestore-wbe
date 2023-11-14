package com.ifsuldeminas.pas.bcc.gamestorewbe.services;

import com.ifsuldeminas.pas.bcc.gamestorewbe.entities.Compra.Compra;
import com.ifsuldeminas.pas.bcc.gamestorewbe.entities.Pessoa.Pessoa;
import com.ifsuldeminas.pas.bcc.gamestorewbe.repositories.CompraRepository;
import com.ifsuldeminas.pas.bcc.gamestorewbe.services.impl.CompraServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class CompraServiceImplTeste {
    @Autowired
    private CompraServiceImpl compraService;
    @Autowired
    private CompraRepository compraRepository;

    @Test
    void listarCompras(){
        assertNotNull(compraService.listarCompras());
    }

    @Test
    void buscarCompraPorId(){
        compraService.buscarCompraPorId(1);
    }

    @Test
    void addCompra(){
        Integer cont = compraService.listarCompras().size();
        Compra compra = new Compra(1, 1.0f);
        compraService.addCompra(compra);
        assertNotNull(compraService.listarCompras().size() > cont);
    }

    @Test
    void atualizarCompra(){
        Compra compra = new Compra(1, 1.0f);
        compraService.addCompra(compra);
        compra.setIdCliente(2);
        compraService.atualizaCompra(compra);
        assertNotNull(compraService.listarCompras().get(0).getIdCliente().equals(2));
    }

    @Test
    void removeCompra(){
        Compra compra = new Compra(1, 1.0f);
        compraService.addCompra(compra);
        Integer cont = compraService.listarCompras().size();
        compraService.deletaCompra(1);
        assertNotNull(compraService.listarCompras().size() < cont);
    }
}
