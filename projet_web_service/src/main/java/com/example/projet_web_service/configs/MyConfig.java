package com.example.projet_web_service.configs;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.projet_web_service.services.CompteRestJaxRSAPI;

@Configuration
public class MyConfig {
@Bean
public ResourceConfig resourceConfig() {
	ResourceConfig jerseyServlet = new ResourceConfig();
	jerseyServlet.register(CompteRestJaxRSAPI.class);
	return jerseyServlet;
}
}
