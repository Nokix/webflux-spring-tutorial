package gmbh.conteco.webfluxspringtutorial;

import gmbh.conteco.webfluxspringtutorial.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/randomusers")
    public Flux<User> getRandomUsers(@RequestParam(defaultValue = "10") int amount) {
        List<User> users = Stream.generate(userService::getNewRandomUser).limit(amount).toList();
        return Flux.fromIterable(users).delayElements(Duration.ofSeconds(1));
    }
}
