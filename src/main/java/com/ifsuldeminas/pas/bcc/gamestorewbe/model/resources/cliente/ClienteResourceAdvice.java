package com.ifsuldeminas.pas.bcc.gamestorewbe.model.resources.cliente;

import com.ifsuldeminas.pas.bcc.gamestorewbe.model.exceptions.cliente.ClienteNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ClienteResourceAdvice {
    @ResponseBody
    @ExceptionHandler(ClienteNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String clienteNotFoundHandler(ClienteNotFoundException ex){
        return ex.getMessage();
    }
}
