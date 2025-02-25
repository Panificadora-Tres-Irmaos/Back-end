package com.example.Backend._3.Irmaos.handler;

import com.example.Backend._3.Irmaos.entity.ErrorPersonalizado;
import com.example.Backend._3.Irmaos.exception.NotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(NotFoundException.class)
    public ErrorPersonalizado handler(NotFoundException ex) {
        return new ErrorPersonalizado(ex.getMessage());
    }

}