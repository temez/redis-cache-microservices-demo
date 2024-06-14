package dev.temez.demo.service.user.controller;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/v1/users/ping")
public class PingController {

  @Value("${server.port}")
  int port;

  @GetMapping(value = "/")
  @ResponseStatus(HttpStatus.OK)
  public @NotNull String getPing() {
    return "Pong from localhost:%d".formatted(port);
  }
}
