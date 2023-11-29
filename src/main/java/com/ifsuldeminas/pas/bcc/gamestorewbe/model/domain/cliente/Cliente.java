package com.ifsuldeminas.pas.bcc.gamestorewbe.model.domain.cliente;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;
import lombok.*;

@Data // gera getters e setters
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idCliente;
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

    public Cliente() {
    }

    public Cliente(String nome, String cpf, String email, LocalDate of, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.dataNasc = of;
        this.telefone = telefone;
    }
}
