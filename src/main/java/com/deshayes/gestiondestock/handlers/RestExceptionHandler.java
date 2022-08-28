package com.deshayes.gestiondestock.handlers;

import com.deshayes.gestiondestock.exception.EntityNotFoundException;
import com.deshayes.gestiondestock.exception.InvalideEntityException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice//Pour éviter d'ajouter responsebody à chaque méthode
public class RestExceptionHandler extends ResponseEntityExceptionHandler {//Utilise l'objet response entity pour la gestion des exceptions

    @ExceptionHandler(EntityNotFoundException.class)//Va gérer spécifiquement les excpetion de cette class
    public ResponseEntity<ErrorDto> handleException( EntityNotFoundException exception,WebRequest webRequest){
        final HttpStatus notFound = HttpStatus.NOT_FOUND;

        return new ResponseEntity<>(ErrorDto.builder()
                                            .code(exception.getErrorCodes())
                                            .httpCode(notFound.value())
                                            .message(exception.getMessage())
                                            .build(),
                                    notFound);
    }


    @ExceptionHandler(InvalideEntityException.class)
    public ResponseEntity<ErrorDto> handleException(InvalideEntityException exception,WebRequest webRequest){
        final HttpStatus badRequest = HttpStatus.BAD_REQUEST;

        return new ResponseEntity<>(ErrorDto.builder()
                                            .code(exception.getErrorCodes())
                                            .httpCode(badRequest.value())
                                            .message(exception.getMessage())
                                            .build(),
                                    badRequest);
    }
}
