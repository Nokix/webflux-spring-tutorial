package gmbh.conteco.webfluxspringtutorial;

import com.github.javafaker.Faker;
import gmbh.conteco.webfluxspringtutorial.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final Faker faker;

    private User createNewRandomUser() {
        return User.builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .build();
    }

    public User getNewRandomUser() {
        return createNewRandomUser();
    }

}
