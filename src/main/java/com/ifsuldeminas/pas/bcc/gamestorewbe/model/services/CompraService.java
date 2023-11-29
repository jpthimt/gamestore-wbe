package com.ifsuldeminas.pas.bcc.gamestorewbe.model.services;


import com.ifsuldeminas.pas.bcc.gamestorewbe.model.domain.compra.Compra;

import java.util.List;

public interface CompraService {
    List<Compra> listarCompras();
    Compra buscarCompraPorId(Integer id);
    void addCompra(Compra compra);
    void atualizaCompra(Compra compra, Integer id);
    void deletaCompra(Integer id);
    Float calculaValorTotal(Compra compra);
}
