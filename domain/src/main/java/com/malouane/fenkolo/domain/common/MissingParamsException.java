package com.malouane.fenkolo.domain.common;

public class MissingParamsException extends IllegalArgumentException {
  public MissingParamsException(Class klass) {
    super("Parameters are mandatory for " + klass.getClass().getSimpleName());
  }
}
