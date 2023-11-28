package com.ifsuldeminas.pas.bcc.gamestorewbe.model.exceptions.jogo;

public class JogoNotFoundException extends RuntimeException{
    public JogoNotFoundException(Integer id){
        super("Jogo com id " + id + " não encontrado");
    }
}
