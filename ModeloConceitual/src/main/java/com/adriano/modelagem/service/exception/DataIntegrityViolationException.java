package com.adriano.modelagem.service.exception;

public class DataIntegrityViolationException extends RuntimeException {

  public DataIntegrityViolationException(String msg) {
    super(msg);
  }

  public DataIntegrityViolationException(String msg, Throwable causa) {
    super(msg, causa);
  }
}
