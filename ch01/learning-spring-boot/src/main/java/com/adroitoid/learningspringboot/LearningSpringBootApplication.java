package com.adroitoid.learningspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import reactor.core.publisher.Flux;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class LearningSpringBootApplication
{

	public static void main(String[] args)
	{
		SpringApplication.run(LearningSpringBootApplication.class, args);
	}



	@Configuration
	public class LoadDatabase
	{

		@Bean
		CommandLineRunner init(ChapterRepository repository)
		{
			return args -> {
				Flux.just(
						new Chapter("Quick Start with Java"),
						new Chapter("Reactive Web with Spring Boot"),
						new Chapter("...and more!"))
						.flatMap(repository::save)
						.subscribe(System.out::println);
			};
		}

	}

}
