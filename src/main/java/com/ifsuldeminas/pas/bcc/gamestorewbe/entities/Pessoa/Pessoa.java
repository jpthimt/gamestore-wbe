package com.ifsuldeminas.pas.bcc.gamestorewbe.entities.Pessoa;

import jakarta.persistence.*;

import java.util.Date;
import lombok.*;

@Data // gera getters e setters
@Entity
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idPessoa;
    @Column
    private String nome;
    @Column
    private String cpf;
    @Column
    private String email;
    @Column
    private Date dataNasc;
    @Column
    private String telefone;

    public Pessoa(String nome, String cpf, String email, Date dataNasc, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.dataNasc = dataNasc;
        this.telefone = telefone;
    }
}
