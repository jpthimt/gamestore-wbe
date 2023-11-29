package com.ifsuldeminas.pas.bcc.gamestorewbe.model.domain.compra;


import com.ifsuldeminas.pas.bcc.gamestorewbe.model.domain.jogo.Jogo;
import jakarta.persistence.*;
import lombok.Data;

@Data // gera getters e setters
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.AUTO)
    private Integer idItem;

    @ManyToOne()
    @JoinColumn(name = "jogo")
    private Jogo jogo;

    @Column
    private Integer quantidade;

    @Column
    private Float valorUnid;

    @Column
    private Float valorTotal;

    public Item(Jogo jogo, Integer quantidade) {
        this.jogo = jogo;
        this.quantidade = quantidade;
        this.valorUnid = jogo.getPriceInitial();
        this.valorTotal = this.valorUnid * this.quantidade;
    }

    public Item() {
    }

    public Integer getIdItem() {
        return idItem;
    }

    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Float getValor() {
        return valorUnid;
    }

}
