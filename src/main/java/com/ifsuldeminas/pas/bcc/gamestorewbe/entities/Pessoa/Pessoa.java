package com.ifsuldeminas.pas.bcc.gamestorewbe.entities.Pessoa;

import java.util.Date;

public class Pessoa {
    private String nome;
    private String cpf;
    private String email;
    private String senha;
    private Date Data_Aniversario;

    public Pessoa(String nome, String cpf, String email, String senha, Date data_Aniversario) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        Data_Aniversario = data_Aniversario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getData_Aniversario() {
        return Data_Aniversario;
    }

    public void setData_Aniversario(Date Data_Aniversario) {
        this.Data_Aniversario = Data_Aniversario;
    }
}
