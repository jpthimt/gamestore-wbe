package com.ifsuldeminas.pas.bcc.gamestorewbe.services.impl;

import com.ifsuldeminas.pas.bcc.gamestorewbe.entities.Compra.Compra;
import com.ifsuldeminas.pas.bcc.gamestorewbe.repositories.CompraRepository;
import com.ifsuldeminas.pas.bcc.gamestorewbe.services.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompraServiceImpl implements CompraService {

    @Autowired
    private CompraRepository compraRepository;

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
        atual.setIdCliente(compra.getIdCliente());
        atual.setValorTotal(compra.getValorTotal());
        compraRepository.save(atual);
    }

    @Override
    public void deletaCompra(Integer id) {
        compraRepository.deleteById(id);
    }
}
