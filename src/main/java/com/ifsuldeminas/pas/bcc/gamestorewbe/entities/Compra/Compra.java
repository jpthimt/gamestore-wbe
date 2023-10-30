package com.ifsuldeminas.pas.bcc.gamestorewbe.entities.Compra;

public class Compra {

    private Integer cod;
    private Integer codCliente;
    private float valorTotal;

    public Compra() {
    }

    public Compra(Integer cod, Integer codCliente, float valorTotal) {
        this.cod = cod;
        this.codCliente = codCliente;
        this.valorTotal = valorTotal;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public Integer getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Integer codCliente) {
        this.codCliente = codCliente;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }
}
