package com.ifsuldeminas.pas.bcc.gamestorewbe.model.exceptions.compra;

public class ItemNotFoundException extends RuntimeException{
    public ItemNotFoundException(Integer id){
        super("Item com id " + id + " não encontrado");
    }
}
