package com.JetClean.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI getOpenAPI(){

        Contact contact = new Contact();
        contact.name("Kimura");
        contact.email("rafaekimura57@gmail.com");

        Info info = new Info();
        info.title("JetClean");
        info.version("V1");
        info.description("Aplicação para gerenciamento de agendamentos de lavagens de carro");
        info.contact(contact);

        return new OpenAPI().info(info);
    }
}
