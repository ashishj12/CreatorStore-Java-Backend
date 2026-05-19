package com.example.creatorstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;
import io.github.cdimascio.dotenv.DotenvEntry;

@SpringBootApplication
public class CreatorStoreApplication {
	public static void main(String[] args) {
		// load environment file
		Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();

		// Set environment variables as system properties
		dotenv.entries().forEach((DotenvEntry entry) -> {
			System.setProperty(entry.getKey(), entry.getValue());
		});

		SpringApplication.run(CreatorStoreApplication.class, args);
	}
}