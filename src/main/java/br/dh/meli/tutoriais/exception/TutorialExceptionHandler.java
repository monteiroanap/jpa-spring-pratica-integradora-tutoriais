package br.dh.meli.tutoriais.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class TutorialExceptionHandler { // captura varias excecoes e trata no controller
    @ExceptionHandler(InvalidParamException.class)
    public ResponseEntity<ExceptionDetails> handlerInvalidParamEXception(InvalidParamException ex) {
        return new ResponseEntity<>(
                ExceptionDetails.builder()
                        .title("Parametro Invalido")
                        .message(ex.getMessage())
                        .timesTamp(LocalDateTime.now())
                        .build(), HttpStatus.BAD_REQUEST);

    }
}
