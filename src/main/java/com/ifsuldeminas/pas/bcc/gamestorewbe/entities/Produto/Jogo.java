import java.util.ArrayList;
import java.util.List;

package com.ifsuldeminas.pas.bcc.gamestorewbe.entities.Produto;

public class Jogo extends Produto {
    private String nome;
    private Date dataLanc;
    private String desenvolvedora;
    private float nota;
    private List<Dlc> dlcs; 

    public Jogo(String nome, Date dataLanc, String desenvolvedora, float nota,Dlc dlcs) {
        super();
        this.nome = nome;
        this.dataLanc = dataLanc;
        this.desenvolvedora = desenvolvedora;
        this.nota = nota;
        this.dlcs = new ArrayList<>();
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
    
    public void adicionarDlc(Dlc dlc) {
        dlcs.add(dlc);
    }

    public List<Dlc> listarDlcs() {
        return dlcs;
    }
}
