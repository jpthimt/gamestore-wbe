package com.ifsuldeminas.pas.bcc.gamestorewbe.services.impl;

import com.ifsuldeminas.pas.bcc.gamestorewbe.entities.Pessoa.Pessoa;
import com.ifsuldeminas.pas.bcc.gamestorewbe.repositories.PessoaRepository;
import com.ifsuldeminas.pas.bcc.gamestorewbe.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaServiceImpl implements PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Override
    public List<Pessoa> listarPessoas() {
        return pessoaRepository.findAll();
    }

    @Override
    public Pessoa buscarPessoaPorId(Integer id) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        return pessoa.orElse(null);
    }

    @Override
    public void addPessoa(Pessoa pessoa) {
        pessoa.setIdPessoa(null);
        pessoaRepository.save(pessoa);
    }

    @Override
    public void atualizaPessoa(Pessoa pessoa) {
        Pessoa atual = this.buscarPessoaPorId(pessoa.getIdPessoa());
        atual.setNome(pessoa.getNome());
        atual.setCpf(pessoa.getCpf());
        atual.setEmail(pessoa.getEmail());
        atual.setDataNasc(pessoa.getDataNasc());
        atual.setTelefone(pessoa.getTelefone());
        pessoaRepository.save(atual);
    }

    @Override
    public void deletaPessoa(Integer id) {
        pessoaRepository.deleteById(id);
    }
}
