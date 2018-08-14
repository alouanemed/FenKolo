package com.malouane.fenkolo.domain.common;

import org.jetbrains.annotations.NotNull;

public class MissingParamsException extends IllegalArgumentException {
  public MissingParamsException(@NotNull Class klass) {
    super("Parameters are mandatory for " + klass.getClass().getSimpleName());
  }
}
