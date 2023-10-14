package com.ifsuldeminas.pas.bcc.gamestorewbe.entities.Pessoa;

import java.util.Date;

public class Funcionario extends Pessoa {
    private Integer codFunc;
    private Integer tipoFunc;

    public Funcionario(String nome, String cpf, String email, String senha, Date data_Aniversario, Integer codFunc, Integer tipoFunc) {
        super(nome, cpf, email, senha, data_Aniversario);
        this.codFunc = codFunc;
        this.tipoFunc = tipoFunc;
    }

    public int getCodFunc() {
        return codFunc;
    }

    public void setCodFunc(int codFunc) {
        this.codFunc = codFunc;
    }

    public int getTipoFunc() {
        return tipoFunc;
    }

    public void setTipoFunc(int tipoFunc) {
        this.tipoFunc = tipoFunc;
    }

}
