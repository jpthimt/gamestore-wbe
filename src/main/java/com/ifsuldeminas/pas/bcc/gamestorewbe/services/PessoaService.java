package com.ifsuldeminas.pas.bcc.gamestorewbe.services;

import com.ifsuldeminas.pas.bcc.gamestorewbe.entities.Pessoa.Pessoa;

import java.util.List;

public interface PessoaService {
    public List<Pessoa> listarPessoas();
    public Pessoa buscarPessoaPorId(Integer id);
    public void addPessoa(Pessoa pessoa);
    public void atualizaPessoa(Pessoa pessoa);
    public void deletaPessoa(Integer id);
}
