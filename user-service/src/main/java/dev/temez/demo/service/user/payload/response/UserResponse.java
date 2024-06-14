package dev.temez.demo.service.user.payload.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.jetbrains.annotations.NotNull;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {

  long id;

  @NotNull
  String username;
}
