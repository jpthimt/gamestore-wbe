package com.ifsuldeminas.pas.bcc.gamestorewbe.model.domain.compra;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ifsuldeminas.pas.bcc.gamestorewbe.model.domain.cliente.Cliente;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data // gera getters e setters
@Entity
public class Compra {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.AUTO)
    private Integer idCompra;

    @Column
    private float valorTotal;

    @Column
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCompra;

    @ManyToOne()
    @JoinColumn(name = "cliente")
    private Cliente cliente;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "idCompra")
    private List<Item> itens;

    public Compra() {
    }

    public Compra(Cliente ciente, LocalDate dataCompra, List<Item> itens) {
        this.cliente = cliente;
        this.dataCompra = dataCompra;
        this.itens = itens;
    }

    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }
}
