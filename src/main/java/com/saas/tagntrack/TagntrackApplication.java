package com.saas.tagntrack;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.ws.rs.ApplicationPath;

@SpringBootApplication
@ApplicationPath("/api")
public class TagntrackApplication extends ResourceConfig {

	public TagntrackApplication() {
		packages("com.saas.tagntrack.controller");
	}

	public static void main(String[] args) {

		SpringApplication.run(TagntrackApplication.class, args);

	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

}
