package com.ifsuldeminas.pas.bcc.gamestorewbe.services.impl;

import com.ifsuldeminas.pas.bcc.gamestorewbe.entities.Compra.Compra;
import com.ifsuldeminas.pas.bcc.gamestorewbe.entities.Compra.Item;
import com.ifsuldeminas.pas.bcc.gamestorewbe.repositories.CompraRepository;
import com.ifsuldeminas.pas.bcc.gamestorewbe.repositories.ItemRepository;
import com.ifsuldeminas.pas.bcc.gamestorewbe.services.ClienteService;
import com.ifsuldeminas.pas.bcc.gamestorewbe.services.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompraServiceImpl implements CompraService {

    @Autowired
    private CompraRepository compraRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private ClienteService clienteService;

    @Override
    public List<Compra> listarCompras() {
        return compraRepository.findAll();
    }

    @Override
    public Compra buscarCompraPorId(Integer id) {
        Optional<Compra> compra = compraRepository.findById(id);
        return compra.orElse(null);
    }

    @Override
    public void addCompra(Compra compra) {
        compra.setIdCompra(null);
        compraRepository.save(compra);
    }

    @Override
    public void atualizaCompra(Compra compra) {
        Compra atual = this.buscarCompraPorId(compra.getIdCompra());
        atual.setCliente(compra.getCliente());
        atual.setDataCompra(compra.getDataCompra());
        atual.setItens(compra.getItens());
        atual.setValorTotal(calculaValorTotal(compra));
        compraRepository.save(atual);
    }

    @Override
    public void deletaCompra(Integer id) {
        compraRepository.deleteById(id);
    }

    @Override
    public Float calculaValorTotal(Compra compra) {
        List<Item> itens = compra.getItens();
        Float total = 0f;
        for (Item item : itens) {
            total += item.getValor()*item.getQuantidade();
        }
        return total;
    }

    @Override
    public Boolean verificaCliente(Compra compra) {
        if (clienteService.buscarClientePorId(compra.getCliente().getIdCliente()) == null){  // Verifica se a cliente existe
            ResponseEntity.badRequest().build();
            System.out.println("Cliente não existe!");
            return false;
        }
        System.out.println("Cliente existe!");
        return true;
    }
}
