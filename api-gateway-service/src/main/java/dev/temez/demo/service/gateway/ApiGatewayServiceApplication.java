package dev.temez.demo.service.gateway;

import org.jetbrains.annotations.NotNull;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = "dev.temez.demo.service.gateway")
public class ApiGatewayServiceApplication {

  public static void main(String @NotNull [] args) {
    SpringApplication.run(ApiGatewayServiceApplication.class, args);
  }
}
