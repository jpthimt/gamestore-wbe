package com.ifsuldeminas.pas.bcc.gamestorewbe.entities.Pessoa;

public class Cliente extends Pessoa{
  private int codCliente;
  private String telefone;

  public Cliente(){
    
}
  public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }
    
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
