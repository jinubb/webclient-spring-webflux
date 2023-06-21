package com.webflux.api.global.core.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.context.annotation.Bean;


@ConstructorBinding
@RequiredArgsConstructor
@ConfigurationProperties("springdoc.swagger-ui")
public class SwaggerConfig {

    private final Server server;
    private final Info info;

    @Bean
    public OpenAPI openApi() {
        return new OpenAPI()
                .addServersItem(server)
                .info(info);
    }

    @Bean
    public GroupedOpenApi productGroupedOpenApi() {
        return GroupedOpenApi
                .builder()
                .packagesToScan("com.webflux.api.government")
                .pathsToMatch("/**")
                .group("Government API")
                .build();
    }
}

