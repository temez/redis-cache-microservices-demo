package dev.temez.demo.service.user.controller;

import com.github.dozermapper.core.Mapper;
import dev.temez.demo.service.user.model.User;
import dev.temez.demo.service.user.payload.request.UserSaveRequest;
import dev.temez.demo.service.user.payload.response.UserResponse;
import dev.temez.demo.service.user.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/users")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UserController {

  @NotNull
  UserService userService;

  @NotNull
  Mapper mapper;

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(value = "/{username}", produces = "application/json")
  public @NotNull UserResponse getByUsername(@PathVariable("username") String username) {
    User user = userService.getByUsername(username);
    return mapper.map(user, UserResponse.class);
  }

  @ResponseStatus(HttpStatus.OK)
  @DeleteMapping(value = "/{username}", produces = "application/json")
  public @NotNull ResponseEntity<?> deleteByUsername(@PathVariable("username") String username) {
    User user = userService.getByUsername(username);
    userService.delete(user);
    return ResponseEntity.ok().build();
  }

  @ResponseStatus(HttpStatus.OK)
  @PostMapping(value = "/", produces = "application/json", consumes = "application/json")
  public @NotNull UserResponse save(@NotNull @RequestBody UserSaveRequest userSaveRequest) {
    User user = mapper.map(userSaveRequest, User.class);
    User savedUser = userService.save(user);
    return mapper.map(savedUser, UserResponse.class);
  }
}
