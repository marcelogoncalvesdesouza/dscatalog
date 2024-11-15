package com.devsuperior.dscatalog.repositories.exceptions;

import com.devsuperior.dscatalog.services.exceptions.DatabaseException;
import com.devsuperior.dscatalog.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> entityNotFound(ResourceNotFoundException e,
                                                        HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError standardError = new StandardError();
        standardError.setTimeStamp(Instant.now());
        standardError.setStatus(status.value());
        standardError.setError("Resource not found.");
        standardError.setMessage(e.getMessage());
        standardError.setPath(request.getRequestURI());
        return ResponseEntity.status(status).body(standardError);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError> database(DatabaseException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError standardError = new StandardError();
        standardError.setTimeStamp(Instant.now());
        standardError.setStatus(status.value());
        standardError.setError("Database exception.");
        standardError.setMessage(e.getMessage());
        standardError.setPath(request.getRequestURI());
        return ResponseEntity.status(status).body(standardError);
    }

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<ErroDeValidacao> validacao(MethodArgumentNotValidException validacao,
//                                                     HttpServletRequest requisicao) {
//        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
//        ErroDeValidacao erro = new ErroDeValidacao();
//        erro.setTimeStamp(Instant.now());
//        erro.setStatus(status.value());
//        erro.setErro("EXCEÇÃO DE VALIDAÇÃO: BENAS VALIDATION!");
//        erro.setMensagem(validacao.getMessage());
//        erro.setCaminho(requisicao.getRequestURI());
//
//        for (FieldError f: validacao.getFieldErrors()) {
//            erro.addErros(f.getField(), f.getDefaultMessage());
//        }
//
//        return ResponseEntity.status(status).body(erro);
//    }

}
