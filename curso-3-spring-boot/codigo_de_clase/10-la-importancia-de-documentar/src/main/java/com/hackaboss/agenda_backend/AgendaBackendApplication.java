package com.hackaboss.agenda_backend;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AgendaBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgendaBackendApplication.class, args);
	}

	@Bean
	public OpenAPI doc(){
		return new OpenAPI().info(new Info()
				.title("Agenda")
				.version("0.0.1")
				.description("Documentación de APIs de Proyecto Agenda"));
	}
}