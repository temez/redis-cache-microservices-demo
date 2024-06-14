package dev.temez.demo.service.user.repository;

import dev.temez.demo.service.user.model.User;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

  @NotNull Optional<User> findByUsername(@NotNull String firstname);

  boolean existsByUsername(@NotNull String username);

}
