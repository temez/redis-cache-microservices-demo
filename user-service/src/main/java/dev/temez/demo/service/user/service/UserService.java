package dev.temez.demo.service.user.service;

import dev.temez.demo.service.user.exception.user.UserAlreadyExistsException;
import dev.temez.demo.service.user.exception.user.UserNotFoundException;
import dev.temez.demo.service.user.model.User;
import org.jetbrains.annotations.NotNull;

public interface UserService {

  @NotNull User getById(long id) throws UserNotFoundException;

  @NotNull User getByUsername(@NotNull String username) throws UserNotFoundException;

  @NotNull User save(@NotNull User user) throws UserAlreadyExistsException;

  void delete(@NotNull User user);
}
