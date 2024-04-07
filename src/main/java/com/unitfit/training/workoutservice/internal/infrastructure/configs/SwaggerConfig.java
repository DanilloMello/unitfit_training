package com.unitfit.training.workoutservice.internal.infrastructure.configs;


import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    final static String SCHEME_NAME = "bearerAuth";
    final static String BEARER_FORMAT = "JWT";
    final static String SCHEME = "bearer";

    @Bean
    public OpenAPI caseOpenAPI() {
        return new OpenAPI()
                .addSecurityItem(new SecurityRequirement()
                        .addList(SCHEME_NAME)).components(new Components()
                        .addSecuritySchemes(
                                SCHEME_NAME, new SecurityScheme()
                                        .name(SCHEME_NAME)
                                        .type(SecurityScheme.Type.HTTP)
                                        .bearerFormat(BEARER_FORMAT)
                                        .in(SecurityScheme.In.HEADER)
                                        .scheme(SCHEME)
                        )
                )
                .info(new Info()
                        .title("Case Management Service")
                        .description("Claim Event Information")
                        .version("1.0")
                );
    }
}