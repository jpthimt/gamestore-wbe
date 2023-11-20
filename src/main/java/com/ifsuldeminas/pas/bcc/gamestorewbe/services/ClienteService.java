package com.ifsuldeminas.pas.bcc.gamestorewbe.services;

import com.ifsuldeminas.pas.bcc.gamestorewbe.entities.Cliente.Cliente;

import java.util.List;

public interface ClienteService {
    public List<Cliente> listarClientes();
    public Cliente buscarClientePorId(Integer id);
    public void addCliente(Cliente cliente);
    public void atualizaCliente(Cliente cliente);
    public void deletaCliente(Integer id);
}
