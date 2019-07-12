package com.adriano.modelagem.resource.exception;

import com.adriano.modelagem.exception.ObjectNotFoundException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

  @ExceptionHandler(ObjectNotFoundException.class)
  public ResponseEntity<DefaultError> objectNotFound(ObjectNotFoundException e,
      HttpServletRequest request) {
    DefaultError erro = new DefaultError(HttpStatus.NOT_FOUND.value(), e.getMessage());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
  }
}
