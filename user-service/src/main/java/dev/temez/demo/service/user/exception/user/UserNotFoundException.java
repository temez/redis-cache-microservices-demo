package dev.temez.demo.service.user.exception.user;

import org.jetbrains.annotations.NotNull;

public class UserNotFoundException extends UserException {

  public UserNotFoundException(@NotNull String message) {
    super(message);
  }
}
