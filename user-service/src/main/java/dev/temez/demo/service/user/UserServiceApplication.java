package dev.temez.demo.service.user;

import org.jetbrains.annotations.NotNull;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableCaching
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = "dev.temez.demo.service.user")
public class UserServiceApplication {

  public static void main(String @NotNull [] args) {
    SpringApplication.run(UserServiceApplication.class, args);
  }
}
