package com.baris.demo.Config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Swagger3Config {
    @Bean
    public OpenAPI myApiDocumentation(){
        return new OpenAPI()
                .info(new Info()
                        .title("Demo")
                        .description("Spring Demo")
                        .version("@"));
    }
}
