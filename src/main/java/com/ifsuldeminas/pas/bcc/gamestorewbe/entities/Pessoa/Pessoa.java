package com.ifsuldeminas.pas.bcc.gamestorewbe.entities.Pessoa;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;
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
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNasc;
    @Column
    private String telefone;

    public Pessoa(String nome, String cpf, String email, LocalDate dataNasc, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.dataNasc = dataNasc;
        this.telefone = telefone;
    }

    public Pessoa() {
    }
}
