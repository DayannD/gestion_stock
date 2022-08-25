package com.deshayes.gestiondestock.exception;

import lombok.Getter;

import java.util.List;

public class InvalideEntityException extends RuntimeException{
    @Getter
    private ErrorCodes errorCodes;
    @Getter
    private List<String> errors;

    public InvalideEntityException(String message){
        super(message);
    }

    public InvalideEntityException(String message,Throwable cause){
        super(message,cause);
    }

    public InvalideEntityException(String message,Throwable cause,ErrorCodes errorCodes){
        super(message,cause);
        this.errorCodes = errorCodes;
    }

    public InvalideEntityException(String message,ErrorCodes errorCodes,List<String> errors){
        super(message);
        this.errorCodes = errorCodes;
        this.errors = errors;
    }
}
