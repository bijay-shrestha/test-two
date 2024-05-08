package dev.bijays.testtwo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestTwoApplication {

	private static final Logger log = LoggerFactory.getLogger(TestTwoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TestTwoApplication.class, args);
		log.info("Application started successfully!");
	}

//	@Bean
//	CommandLineRunner runner(JdbcClientRunRepository runRepository)
//	{
//		return args -> {
//			Run run = new Run(1, "First Run", LocalDateTime.now(),
//					LocalDateTime.now().plusHours(1), 3, Location.OUTDOOR);
//			runRepository.create(run);
//		};
//	}


}
