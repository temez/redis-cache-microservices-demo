package dev.temez.demo.service.user.exception.handler;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.jetbrains.annotations.NotNull;

@Getter
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ExceptionResponse {

  @NotNull
  Class<?> exceptionClass;

  @NotNull
  String message;

}
