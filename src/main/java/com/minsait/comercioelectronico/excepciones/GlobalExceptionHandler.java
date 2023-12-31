package com.minsait.comercioelectronico.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.persistence.NoResultException;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException (NotFoundException e){
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ErrorResponse> handleFaltaParámetro (MissingServletRequestParameterException e){
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "Falta el parámetro " + e.getParameterName());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorResponse> handleFormatoErroneo (MethodArgumentTypeMismatchException e){
        ErrorResponse errorResponse = null;
        if (e.getName().equals("fecha")){
            errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "El formato del campo " + e.getName() + " no es correcto. El formato aceptado es yyyy-MM-dd HH:mm:ss");
        }
        else {
            errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "El formato del campo " + e.getName() + " no es correcto");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(NoResultException.class)
    public ResponseEntity<ErrorResponse> handleNoResultException (NoResultException e){
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), "Precio no disponible");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }
}
