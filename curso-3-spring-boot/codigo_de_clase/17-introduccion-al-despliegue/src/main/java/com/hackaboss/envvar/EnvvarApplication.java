package com.hackaboss.envvar;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EnvvarApplication implements CommandLineRunner {
	@Value("${spring.datasource.url}")
	public String url;
	@Value("${spring.datasource.username}")
	public String username;
	@Value("${spring.datasource.password}")
	public String password;
	@Value("${mensaje}")
	public String msje;

	public static void main(String[] args) {SpringApplication.run(EnvvarApplication.class, args);}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("URL: " + url);
		System.out.println("Nombre: " + username);
		System.out.println("Password: " + password);
		System.out.println("Mensaje: " + msje);
	}
}
