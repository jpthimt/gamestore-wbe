package com.ifsuldeminas.pas.bcc.gamestorewbe.services;

import com.ifsuldeminas.pas.bcc.gamestorewbe.model.domain.cliente.Cliente;
import com.ifsuldeminas.pas.bcc.gamestorewbe.model.domain.compra.Compra;
import com.ifsuldeminas.pas.bcc.gamestorewbe.model.domain.compra.Item;
import com.ifsuldeminas.pas.bcc.gamestorewbe.model.domain.jogo.Jogo;
import com.ifsuldeminas.pas.bcc.gamestorewbe.model.repositories.CompraRepository;
import com.ifsuldeminas.pas.bcc.gamestorewbe.model.services.ClienteService;
import com.ifsuldeminas.pas.bcc.gamestorewbe.model.services.CompraService;
import com.ifsuldeminas.pas.bcc.gamestorewbe.model.services.ItemService;
import com.ifsuldeminas.pas.bcc.gamestorewbe.model.services.JogoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CompraServiceImplTeste {
    @Autowired
    private CompraService compraService;
    @Autowired
    private CompraRepository compraRepository;
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private JogoService jogoService;
    @Autowired
    private ItemService itemService;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @BeforeEach
    public void setup() {
        Cliente cliente = new Cliente();
        Jogo jogo = new Jogo();
        Item item = new Item();
        Compra compra = new Compra();
    }

    @Test
    public void realizarCompra() {
        Cliente cliente1 = new Cliente("nome1", "cpf", "email", LocalDate.of(2001, 01, 01), "telefone");
        clienteService.addCliente(cliente1);
//        System.out.println(cliente1.toString());
        Jogo jogo1 = new Jogo("nome1", LocalDate.of(2000, 01, 10), 1.0f, 1, 1.0f, "url");
        Jogo jogo2 = new Jogo("nome2", LocalDate.of(2000, 01, 10), 1.0f, 1, 1.0f, "url");
        jogoService.addJogo(jogo1);
//        System.out.println(jogo1.toString());
//        System.out.println(jogo2.toString());
        Item item1 = new Item(jogo1, 1);
//        Item item1 = new Item(jogo2, 1);  // Se adicionar com jogo2 dá erro, pois jogo2 não foi adicionado ao banco de dados
        itemService.addItem(item1);
        System.out.println(item1.toString());
//        List<Item> itens = new ArrayList<Item>();
//        itens.add(item1);
        Compra compra1 = new Compra(cliente1, List.of(item1));
        compraService.addCompra(compra1);
        System.out.println(compra1.toString());
        assertNotNull(compraService.buscarCompraPorId(1));
//        assertTrue(compraService.buscarCompraPorId(1) == null);
    }

    @Test
    public void atualizarCompra(){
        Cliente cliente1 = new Cliente("nome1", "cpf", "email", LocalDate.of(2001, 01, 01), "telefone");
        clienteService.addCliente(cliente1);
        Cliente cliente2 = new Cliente("nome2", "cpf", "email", LocalDate.of(2001, 01, 01), "telefone");
        clienteService.addCliente(cliente2);
        Jogo jogo1 = new Jogo("nome1", LocalDate.of(2000, 01, 10), 1.0f, 1, 1.0f, "url");
        jogoService.addJogo(jogo1);
        Item item1 = new Item(jogo1, 1);
        itemService.addItem(item1);
        List<Item> itens = new ArrayList<>();
        itens.add(item1);
        Compra compra1 = new Compra(cliente1, itens);
        compraService.addCompra(compra1);
        Compra compra2 = new Compra(cliente2, itens);
        compraService.atualizaCompra(compra2, compra1.getIdCompra());
        assertEquals(compra2.getCliente(), compraService.buscarCompraPorId(compra1.getIdCompra()).getCliente());
    }
}
