import java.util.Date;
package com.ifsuldeminas.pas.bcc.gamestorewbe.entities.Pessoa;

public class Pessoa{
  private String nome;
  private String cpf;
  private String email;
  private String senha;
  private date Data_Aniversario;
  
public Pessoa(){
    
}
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
  public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
  public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
  public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
  public date getData_Aniversario() {
        return Data_Aniversario;
    }

    public void setData_Aniversario(String Data_Aniversario) {
        this.Data_Aniversario = Data_Aniversario;
    }
}
