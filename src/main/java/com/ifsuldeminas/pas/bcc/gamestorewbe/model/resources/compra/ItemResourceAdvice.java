package com.ifsuldeminas.pas.bcc.gamestorewbe.model.resources.compra;

import com.ifsuldeminas.pas.bcc.gamestorewbe.model.exceptions.compra.ItemNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ItemResourceAdvice {
    @ResponseBody
    @ExceptionHandler(ItemNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String itemNotFoundHandler(ItemNotFoundException ex){
        return ex.getMessage();
    }
}
