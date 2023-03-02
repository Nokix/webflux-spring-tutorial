package gmbh.conteco.webfluxspringtutorial;

import com.github.javafaker.Faker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WebfluxSpringTutorialApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebfluxSpringTutorialApplication.class, args);
	}

	@Bean
	public Faker faker() {
		return new Faker();
	}

}
