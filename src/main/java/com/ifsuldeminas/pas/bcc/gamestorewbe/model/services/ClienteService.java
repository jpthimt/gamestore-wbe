package com.ifsuldeminas.pas.bcc.gamestorewbe.model.services;



import com.ifsuldeminas.pas.bcc.gamestorewbe.model.domain.cliente.Cliente;

import java.util.List;

public interface ClienteService {
    List<Cliente> listarClientes();
    Cliente buscarClientePorId(Integer id);
    void addCliente(Cliente cliente);
    void atualizaCliente(Cliente cliente);
    void deletaCliente(Integer id);
}
