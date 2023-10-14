package com.ifsuldeminas.pas.bcc.gamestorewbe.entities.Pessoa;

import java.net.Inet4Address;
import java.util.Date;

public class Cliente extends Pessoa{
    private Integer codCliente;
    private String telefone;

    public Cliente(String nome, String cpf, String email, String senha, Date data_Aniversario, Integer codCliente, String telefone) {
        super(nome, cpf, email, senha, data_Aniversario);
        this.codCliente = codCliente;
        this.telefone = telefone;
    }

    public Integer getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Integer codCliente) {
        this.codCliente = codCliente;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
