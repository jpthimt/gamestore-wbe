package com.ifsuldeminas.pas.bcc.gamestorewbe.entities.Produto;

public class Produto {
  private int codProduto;
  private float valor;

  public Produto(){
  }

  public Produto(int codProduto, float valor){
    this.codProduto = codProduto;
    this.valor = valor;
  }
  
  public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
  }
  
  public String getCodProduto() {
        return email;
  }

  public void setValor(float valor) {
        this.valor = valor;
  }
  
  public String getValor() {
        return valor;
  }
  
}
