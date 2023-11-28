package com.ifsuldeminas.pas.bcc.gamestorewbe.model.exceptions.cliente;

public class ClienteNotFoundException extends RuntimeException{
    public ClienteNotFoundException(Integer id){
        super("Cliente com id " + id + " não encontrado");
    }
}
