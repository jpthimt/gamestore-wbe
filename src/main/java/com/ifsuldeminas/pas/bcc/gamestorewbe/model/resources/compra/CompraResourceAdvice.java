package com.ifsuldeminas.pas.bcc.gamestorewbe.model.resources.compra;

import com.ifsuldeminas.pas.bcc.gamestorewbe.model.exceptions.compra.CompraNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CompraResourceAdvice {
    @ResponseBody
    @ExceptionHandler(CompraNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String compraNotFoundHandler(CompraNotFoundException ex){
        return ex.getMessage();
    }
}
