package dev.temez.demo.service.user.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@Configuration
@Profile("swagger")
@OpenAPIDefinition(
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