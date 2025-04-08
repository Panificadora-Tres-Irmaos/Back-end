package com.example.Backend._3.Irmaos.handler;

import com.example.Backend._3.Irmaos.entity.ErrorPersonalizado;
import com.example.Backend._3.Irmaos.exception.*;
import com.example.Backend._3.Irmaos.exception.NullPointerException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND) // Define o status HTTP 404
    @ExceptionHandler(NotFoundException.class)
    public ErrorPersonalizado handler(NotFoundException ex) {
        return new ErrorPersonalizado(ex.getMessage());
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    @ExceptionHandler(FailPasswordException.class)
    public ErrorPersonalizado handler(FailPasswordException ex) {return new ErrorPersonalizado(ex.getMessage());}

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND) // Define o status HTTP 404
    @ExceptionHandler(NullPointerException.class)
    public ErrorPersonalizado handler(com.example.Backend._3.Irmaos.exception.NullPointerException ex) {
        return new ErrorPersonalizado(ex.getMessage());
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.PAYMENT_REQUIRED) // Define o status HTTP 404
    @ExceptionHandler(InsuficientFundsException.class)
    public ErrorPersonalizado handler(InsuficientFundsException ex) {
        return new ErrorPersonalizado(ex.getMessage());
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(SameValuesException.class)
    public ErrorPersonalizado handler(SameValuesException ex) {
        return new ErrorPersonalizado(ex.getMessage());
    }

}