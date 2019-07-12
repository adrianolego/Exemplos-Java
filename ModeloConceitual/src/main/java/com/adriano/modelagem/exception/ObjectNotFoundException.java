package com.adriano.modelagem.exception;

public class ObjectNotFoundException extends RuntimeException {

  public ObjectNotFoundException(String msg) {
    super(msg);
  }

  public ObjectNotFoundException(String msg, Throwable causa) {
    super(msg, causa);
  }
}
