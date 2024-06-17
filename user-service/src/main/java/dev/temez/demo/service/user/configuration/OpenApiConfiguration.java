package dev.temez.demo.service.user.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@Configuration
@Profile("swagger")
@OpenAPIDefinition(
    servers = {
        @Server(
            url = "http://localhost:8080/users",
            description = "Api Gateway"
        ),
        @Server(
            url = "http://localhost:${server.port}",
            description = "User service"
        )
    },
    info = @Info(
        version = "0.0.0.1-SNAPSHOT",
        title = "User service",
        contact = @Contact(
            name = "temez",
            email = "temezf@gmail.com"
        )
    )
)
public class OpenApiConfiguration {

}