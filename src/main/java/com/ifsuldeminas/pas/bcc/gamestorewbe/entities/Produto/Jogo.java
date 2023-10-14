package com.ifsuldeminas.pas.bcc.gamestorewbe.entities.Produto;

import com.ifsuldeminas.pas.bcc.gamestorewbe.entities.Produto.Dlc;
import com.ifsuldeminas.pas.bcc.gamestorewbe.entities.Produto.Produto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Jogo extends Produto {
    private String nome;
    private Date dataLanc;
    private String desenvolvedora;
    private Float nota;
    private List<Dlc> dlcs;

    public Jogo(Integer codProduto, Float valor, String nome, Date dataLanc, String desenvolvedora, Float nota, List<Dlc> dlcs) {
        super(codProduto, valor);
        this.nome = nome;
        this.dataLanc = dataLanc;
        this.desenvolvedora = desenvolvedora;
        this.nota = nota;
        this.dlcs = dlcs;
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

    public void setNota(Float nota) {
        this.nota = nota;
    }

    public Float getNota() {
        return nota;
    }
    
    public void adicionarDlc(Dlc dlc) {
        dlcs.add(dlc);
    }

    public List<Dlc> listarDlcs() {
        return dlcs;
    }
}
