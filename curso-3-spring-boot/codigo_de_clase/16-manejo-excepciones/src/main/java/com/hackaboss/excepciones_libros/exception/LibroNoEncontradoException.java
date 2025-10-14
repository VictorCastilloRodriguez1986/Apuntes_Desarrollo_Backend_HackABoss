package com.hackaboss.excepciones_libros.exception;

public class LibroNoEncontradoException extends RuntimeException {
  public LibroNoEncontradoException(String message) {
    super(message);
  }
}