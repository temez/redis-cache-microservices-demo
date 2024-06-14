package dev.temez.demo.service.user.exception.user;

import org.jetbrains.annotations.NotNull;

public class UserAlreadyExistsException extends UserException {

  public UserAlreadyExistsException(@NotNull String message) {
    super(message);
  }
}
