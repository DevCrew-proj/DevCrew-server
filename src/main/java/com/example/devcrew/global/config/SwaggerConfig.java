package com.example.devcrew.global.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {
    private final String JWT = "JWT";
    private final String BEARER = "Bearer";

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .servers(getServers())
                .info(getInfo())
                .components(getComponents());
    }

    private List<Server> getServers() {
        return List.of(new Server()
                .url("/api")
                .description("백엔드 api 서버")
        );
    }

    private Info getInfo() {
        return new Info()
                .title("DevCrew API")
                .description("데브크루 API")
                .version("demo");
    }

    private Components getComponents() {
        return new Components().addSecuritySchemes("access_token", new SecurityScheme()
                .name("Authorization")
                .scheme(BEARER)
                .bearerFormat(JWT)
                .in(SecurityScheme.In.HEADER)
                .type(SecurityScheme.Type.HTTP)
        );
    }
}

