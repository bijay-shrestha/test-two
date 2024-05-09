package dev.bijays.testtwo;

import dev.bijays.testtwo.user.User;
import dev.bijays.testtwo.user.UserHttpClient;
import dev.bijays.testtwo.user.UserRestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import java.util.List;

@SpringBootApplication
public class TestTwoApplication {

	private static final Logger log = LoggerFactory.getLogger(TestTwoApplication.class);

	@Bean
	UserHttpClient userHttpClient(){
		RestClient restClient = RestClient.create("https://jsonplaceholder.typicode.com/");
		HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(RestClientAdapter.create(restClient)).build();
		return factory.createClient(UserHttpClient.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(TestTwoApplication.class, args);
		log.info("Application started successfully!");
	}

	@Bean
	CommandLineRunner runner(UserHttpClient userHttpClient)
	{
		return args -> {
			List<User> users = userHttpClient.findAll();
			System.out.println(users);

			User user = userHttpClient.findById(1);
			System.out.println(user);
		};
	}


}
