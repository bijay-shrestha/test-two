package dev.bijays.testtwo;

import dev.bijays.testtwo.run.Location;
import dev.bijays.testtwo.run.Run;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class TestTwoApplication {

	private static final Logger log = LoggerFactory.getLogger(TestTwoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TestTwoApplication.class, args);
		log.info("Application started successfully!");
	}

	@Bean
	CommandLineRunner runner()
	{
		return args -> {
			Run run = new Run(1, "First Run", LocalDateTime.now(),
					LocalDateTime.now().plusHours(1), 3, Location.OUTDOOR);
			log.info("Run: " + run);
		};
	}


}
