package gmbh.conteco.webfluxspringtutorial.service;

import com.github.javafaker.Faker;
import gmbh.conteco.webfluxspringtutorial.entity.User;
import gmbh.conteco.webfluxspringtutorial.exception.UserNotFoundException;
import gmbh.conteco.webfluxspringtutorial.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final Faker faker;

    private User createNewRandomUser() {
        return User.builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .build();
    }

    public Flux<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Flux<User> createNewUsers(int amount) {
        return userRepository.saveAll(
                Stream.generate(this::createNewRandomUser)
                        .limit(amount)
                        .toList()
        );
    }

    public Mono<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public Flux<User> getUserByName(String name) {
        return userRepository.getUserByName(name);
    }
}
