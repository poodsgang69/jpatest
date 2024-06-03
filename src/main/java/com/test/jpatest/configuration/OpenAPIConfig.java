package com.test.jpatest.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {
    @Bean
    public OpenAPI JpaTestApplicationAPI() {

        OpenAPI openApi = new OpenAPI();
        openApi.info(getInfo());
        return openApi;
    }

    private Info getInfo() {
        return new Info()
                .title("GIS Booking Automation Service")
                .description("List of endpoints related to GIS Booking Automation Service ");

    }
}