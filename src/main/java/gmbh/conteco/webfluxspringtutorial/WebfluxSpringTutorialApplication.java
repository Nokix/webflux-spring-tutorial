package gmbh.conteco.webfluxspringtutorial;

import com.github.javafaker.Faker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableR2dbcRepositories
@EnableWebFlux
public class WebfluxSpringTutorialApplication {

	//https://www.bezkoder.com/spring-boot-r2dbc-h2/
	public static void main(String[] args) {
		SpringApplication.run(WebfluxSpringTutorialApplication.class, args);
	}

	@Bean
	public Faker faker() {
		return new Faker();
	}

}
