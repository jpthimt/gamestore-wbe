package com.ifsuldeminas.pas.bcc.gamestorewbe.entities.Compra;

public class Itens {
    private Integer cod;
    private Integer codCompra;
    private Integer codProduto;
    private Integer quantidade;
    private Float valor;

    public Itens() {
    }

    public Itens(Integer cod, Integer codCompra, Integer codProduto, Integer quantidade, Float valor) {
        this.cod = cod;
        this.codCompra = codCompra;
        this.codProduto = codProduto;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public Integer getCodCompra() {
        return codCompra;
    }

    public void setCodCompra(Integer codCompra) {
        this.codCompra = codCompra;
    }

    public Integer getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(Integer codProduto) {
        this.codProduto = codProduto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }
}
