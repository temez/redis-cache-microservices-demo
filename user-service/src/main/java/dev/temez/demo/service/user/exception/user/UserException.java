package dev.temez.demo.service.user.exception.user;

import org.jetbrains.annotations.NotNull;

public class UserException extends RuntimeException {

  public UserException(@NotNull String message) {
    super(message);
  }
}
