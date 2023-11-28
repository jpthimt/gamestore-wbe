package com.ifsuldeminas.pas.bcc.gamestorewbe.model.exceptions.compra;

public class CompraNotFoundException extends RuntimeException{
    public CompraNotFoundException(Integer id){
        super("Compra com id " + id + " não encontrada");
    }
}
