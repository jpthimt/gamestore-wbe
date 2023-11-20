package com.ifsuldeminas.pas.bcc.gamestorewbe.services.impl;

import com.ifsuldeminas.pas.bcc.gamestorewbe.entities.Cliente.Cliente;
import com.ifsuldeminas.pas.bcc.gamestorewbe.repositories.ClienteRepository;
import com.ifsuldeminas.pas.bcc.gamestorewbe.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarClientePorId(Integer id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.orElse(null);
    }

    @Override
    public void addCliente(Cliente cliente) {
        cliente.setIdCliente(null);
        clienteRepository.save(cliente);
    }

    @Override
    public void atualizaCliente(Cliente cliente) {
        Cliente atual = this.buscarClientePorId(cliente.getIdCliente());
        atual.setNome(cliente.getNome());
        atual.setCpf(cliente.getCpf());
        atual.setEmail(cliente.getEmail());
        atual.setDataNasc(cliente.getDataNasc());
        atual.setTelefone(cliente.getTelefone());
        clienteRepository.save(atual);
    }

    @Override
    public void deletaCliente(Integer id) {
        clienteRepository.deleteById(id);
    }
}
