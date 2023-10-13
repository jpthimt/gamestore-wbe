package com.ifsuldeminas.pas.bcc.gamestorewbe.entities.Produto;

public class Jogo extends Produto {
    private String nome;
    private Date dataLanc;
    private String desenvolvedora;
    private float nota;

    public Jogo(String nome, Date dataLanc, String desenvolvedora, float nota) {
        super();
        this.nome = nome;
        this.dataLanc = dataLanc;
        this.desenvolvedora = desenvolvedora;
        this.nota = nota;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setDataLanc(Date dataLanc) {
        this.dataLanc = dataLanc;
    }

    public Date getDataLanc() {
        return dataLanc;
    }

    public void setDesenvolvedora(String desenvolvedora) {
        this.desenvolvedora = desenvolvedora;
    }

    public String getDesenvolvedora() {
        return desenvolvedora;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public float getNota() {
        return nota;
    }
}
