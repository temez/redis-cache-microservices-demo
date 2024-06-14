package dev.temez.demo.service.eureka;

import org.jetbrains.annotations.NotNull;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication(scanBasePackages = "dev.temez.demo.service.eureka")
public class EurekaServiceApplication {

  public static void main(String @NotNull [] args) {
    SpringApplication.run(EurekaServiceApplication.class, args);
  }
}
