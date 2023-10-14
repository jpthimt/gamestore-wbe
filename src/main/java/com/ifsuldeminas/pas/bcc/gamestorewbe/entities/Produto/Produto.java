package com.ifsuldeminas.pas.bcc.gamestorewbe.entities.Produto;

public class Produto {
  private Integer codProduto;
  private Float valor;

  public Produto(Integer codProduto, Float valor){
    this.codProduto = codProduto;
    this.valor = valor;
  }
  
    public void setCodProduto(Integer codProduto) {
        this.codProduto = codProduto;
  }

  public Integer getCodProduto() {
        return codProduto;
  }

  public void setValor(Float valor) {
        this.valor = valor;
  }
  
    public Float getValor() {
        return valor;
  }
  
}
