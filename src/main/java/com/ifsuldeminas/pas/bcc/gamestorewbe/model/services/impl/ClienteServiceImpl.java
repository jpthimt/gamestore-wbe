package com.ifsuldeminas.pas.bcc.gamestorewbe.model.services.impl;


import com.ifsuldeminas.pas.bcc.gamestorewbe.model.domain.cliente.Cliente;
import com.ifsuldeminas.pas.bcc.gamestorewbe.model.exceptions.cliente.ClienteNotFoundException;
import com.ifsuldeminas.pas.bcc.gamestorewbe.model.exceptions.jogo.JogoNotFoundException;
import com.ifsuldeminas.pas.bcc.gamestorewbe.model.repositories.ClienteRepository;
import com.ifsuldeminas.pas.bcc.gamestorewbe.model.services.ClienteService;
import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    private static final Logger LOG = org.slf4j.LoggerFactory.getLogger(ClienteServiceImpl.class);

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarClientePorId(Integer id) throws ClienteNotFoundException {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (!cliente.isPresent()){
            throw new ClienteNotFoundException(id);
        }
        return cliente.orElse(null);
    }

    @Override
    public void addCliente(Cliente cliente) {
        clienteRepository.save(cliente);
        LOG.info("Cliente adicionado com sucesso");
    }

    @Override
    public void atualizaCliente(Cliente cliente) throws ClienteNotFoundException{
        if (!this.clienteRepository.existsById(cliente.getIdCliente())){
            throw new ClienteNotFoundException(cliente.getIdCliente());
        }
        Cliente atual = this.buscarClientePorId(cliente.getIdCliente());
        atual.setNome(cliente.getNome());
        atual.setCpf(cliente.getCpf());
        atual.setEmail(cliente.getEmail());
        atual.setDataNasc(cliente.getDataNasc());
        atual.setTelefone(cliente.getTelefone());
        clienteRepository.save(atual);
        LOG.info("Cliente atualizado com sucesso");
    }

    @Override
    public void deletaCliente(Integer id) throws ClienteNotFoundException{
        if (!this.clienteRepository.existsById(id)){
            throw new ClienteNotFoundException(id);
        }
        clienteRepository.deleteById(id);
        LOG.info("Cliente deletado com sucesso");
    }
}
