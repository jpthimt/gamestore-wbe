package com.ifsuldeminas.pas.bcc.gamestorewbe.model.services;


import com.ifsuldeminas.pas.bcc.gamestorewbe.model.domain.compra.Compra;

import java.util.List;

public interface CompraService {
    public List<Compra> listarCompras();
    public Compra buscarCompraPorId(Integer id);
    public void addCompra(Compra compra);
    public void atualizaCompra(Compra compra, Integer id);
    public void deletaCompra(Integer id);
    public Float calculaValorTotal(Compra compra);
}
