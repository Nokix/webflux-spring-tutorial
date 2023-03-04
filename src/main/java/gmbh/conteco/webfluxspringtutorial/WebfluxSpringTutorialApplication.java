package gmbh.conteco.webfluxspringtutorial;

import com.github.javafaker.Faker;
import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.r2dbc.connection.init.CompositeDatabasePopulator;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableR2dbcRepositories // not necessary
@EnableWebFlux
public class WebfluxSpringTutorialApplication {

    //https://www.bezkoder.com/spring-boot-r2dbc-h2/
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(WebfluxSpringTutorialApplication.class, args);
    }

    @Bean
    public Faker faker() {
        return new Faker();
    }

    @Bean
    public ConnectionFactoryInitializer databaseInitializer(
            ConnectionFactory connectionFactory
    ) {
        ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
        initializer.setConnectionFactory(connectionFactory);

        CompositeDatabasePopulator populator = new CompositeDatabasePopulator();
        populator.addPopulators(
                new ResourceDatabasePopulator(new ClassPathResource("schema.sql")),
                new ResourceDatabasePopulator(new ClassPathResource("data.sql"))
        );
        initializer.setDatabasePopulator(populator);

        return initializer;
    }

}
