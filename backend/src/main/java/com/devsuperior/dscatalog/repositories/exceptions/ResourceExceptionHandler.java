package com.devsuperior.dscatalog.repositories.exceptions;

import com.devsuperior.dscatalog.services.exceptions.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<StandardError> entityNotFound(EntityNotFoundException e,
                                                              HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError standardError = new StandardError();
        standardError.setTimeStamp(Instant.now());
        standardError.setStatus(status.value());
        standardError.setError("CONTROLLER - 404 (ID Não encontrado).");
        standardError.setMessage(e.getMessage());
        standardError.setPath(request.getRequestURI());
        return ResponseEntity.status(status).body(standardError);
    }

//    @ExceptionHandler(IntegridadeBD.class)
//    public ResponseEntity<ErroPadrao> integridadeBD(IntegridadeBD integridade,
//                                                    HttpServletRequest requisicao) {
//        HttpStatus status = HttpStatus.BAD_REQUEST;
//        ErroPadrao erroPadrao = new ErroPadrao();
//        erroPadrao.setTimeStamp(Instant.now());
//        erroPadrao.setStatus(status.value());
//        erroPadrao.setErro("CONTROLLER - 400 (Violação de Integridade).");
//        erroPadrao.setMensagem(integridade.getMessage());
//        erroPadrao.setCaminho(requisicao.getRequestURI());
//        return ResponseEntity.status(status).body(erroPadrao);
//    }
//
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
