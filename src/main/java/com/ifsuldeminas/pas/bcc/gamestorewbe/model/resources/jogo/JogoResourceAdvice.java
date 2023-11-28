package com.ifsuldeminas.pas.bcc.gamestorewbe.model.resources.jogo;

import com.ifsuldeminas.pas.bcc.gamestorewbe.model.exceptions.jogo.JogoNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class JogoResourceAdvice{
    @ResponseBody
    @ExceptionHandler(JogoNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String jogoNotFoundHandler(JogoNotFoundException ex){
        return ex.getMessage();
    }
}
