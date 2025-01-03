package com.kamelprojet.classyadmin.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("dev")
@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "ClassyAdmin API",
                version = "1.0",
                description = "API documentation for ClassyAdmin backend actions"
        )
)
public class SwaggerConfig {
    // La configuration de base de Swagger est gérée automatiquement par springdoc.
}
