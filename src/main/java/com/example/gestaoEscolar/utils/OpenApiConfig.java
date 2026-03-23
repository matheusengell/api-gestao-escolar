package com.example.gestaoEscolar.utils;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Gestão Escolar")
                        .version("1.0")
                        .description("Sistema desenvolvido para o gerenciamento completo de alunos, " +
                                "matrículas e registros acadêmicos.")
                        .contact(new Contact()
                                .name("Matheus Engel")
                                .email("matheus_engel@estudante.sesisenai.org.br")
                                .url("https://github.com/matheusengell"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://springdoc.org")));
    }
}