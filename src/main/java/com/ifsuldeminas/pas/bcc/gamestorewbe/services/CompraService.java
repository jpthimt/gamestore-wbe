package com.ifsuldeminas.pas.bcc.gamestorewbe.services;

import com.ifsuldeminas.pas.bcc.gamestorewbe.entities.Compra.Compra;

import java.util.List;

public interface CompraService {
    public List<Compra> listarCompras();
    public Compra buscarCompraPorId(Integer id);
    public void addCompra(Compra compra);
    public void atualizaCompra(Compra compra);
    public void deletaCompra(Integer id);
}
