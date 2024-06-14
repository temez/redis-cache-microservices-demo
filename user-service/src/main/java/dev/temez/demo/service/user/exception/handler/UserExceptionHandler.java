package dev.temez.demo.service.user.exception.handler;

import dev.temez.demo.service.user.exception.user.UserException;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserExceptionHandler {

  @ExceptionHandler(UserException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @NotNull ExceptionResponse handle(@NotNull UserException exception) {
    return new ExceptionResponse(
        exception.getClass(),
        exception.getMessage()
    );
  }
}
