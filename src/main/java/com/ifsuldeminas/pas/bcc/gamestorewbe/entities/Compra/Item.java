package com.ifsuldeminas.pas.bcc.gamestorewbe.entities.Compra;

import com.ifsuldeminas.pas.bcc.gamestorewbe.entities.Jogo.Jogo;
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

    public Item() {
    }

    public Item( Jogo jogo, Integer quantidade) {
        this.jogo = jogo;
        this.quantidade = quantidade;
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

    public void setValor(Float valorUnid) {
        this.valorUnid = valorUnid;
    }
}
