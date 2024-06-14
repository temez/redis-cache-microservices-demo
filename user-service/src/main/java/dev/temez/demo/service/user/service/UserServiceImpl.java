package dev.temez.demo.service.user.service;

import dev.temez.demo.service.user.exception.user.UserAlreadyExistsException;
import dev.temez.demo.service.user.exception.user.UserNotFoundException;
import dev.temez.demo.service.user.model.User;
import dev.temez.demo.service.user.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UserServiceImpl implements UserService {

  @NotNull
  UserRepository userRepository;

  @Override
  @Cacheable(value = "users", key = "#id")
  public @NotNull User getById(long id) throws UserNotFoundException {
    log.debug("Retrieving user with id {}", id);
    return userRepository.findById(id)
        .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
  }

  @Override
  @Cacheable(value = "users", key = "#username")
  public @NotNull User getByUsername(@NotNull String username) throws UserNotFoundException {
    log.debug("Retrieving user with username {}", username);
    return userRepository.findByUsername(username)
        .orElseThrow(() -> new UserNotFoundException("User not found with username: " + username));
  }

  @Override
  @Caching(
      put = {
          @CachePut(value = "users", key = "#result.username"),
          @CachePut(value = "users", key = "#result.id")
      }
  )
  public @NotNull User save(@NotNull User user) throws UserAlreadyExistsException {
    if (user.getId() == 0 && userRepository.existsByUsername(user.getUsername())) {
      throw new UserAlreadyExistsException("User already exists with username: " + user.getUsername());
    }
    log.debug("Saving user with username {}", user.getUsername());
    return userRepository.save(user);
  }

  @Override
  @Caching(
      evict = {
          @CacheEvict(value = "users", key = "#user.username"),
          @CacheEvict(value = "users", key = "#user.id")
      }
  )
  public void delete(@NotNull User user) {
    log.debug("Deleting user with username {}", user.getUsername());
    userRepository.delete(user);
  }
}
