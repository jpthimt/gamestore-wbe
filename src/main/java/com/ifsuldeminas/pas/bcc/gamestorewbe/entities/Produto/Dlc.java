package com.ifsuldeminas.pas.bcc.gamestorewbe.entities.Produto;

public class Dlc extends Produto{
  private String nome;
  private Jogo ref_jogo;
  
  public Dlc(String nome, Jogo ref_jogo){
    super();
    this.nome = nome;
    this.ref_jogo = ref_jogo;
  }
  
  public void setNome(String nome) {
      this.nome = nome;
  }

  public String getNome() {
      return nome;
  }
  
  public void setRef_jogo(Jogo ref_jogo) {
      this.ref_jogo = ref_jogo;
  }

  public Jogo getRef_jogo() {
      return ref_jogo;
  }
  
}
