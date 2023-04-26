package gmbh.conteco.webfluxspringtutorial.controller;

import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

@RestController
@RequiredArgsConstructor
public class ReactiveNameController {
    public final Faker faker;

    @GetMapping("/names")
    public Flux<String> getNames(
            @RequestParam(defaultValue = "10") int amount
    ) {
        List<String> names = Stream
                .generate(() -> faker.name().fullName() + " ")
                .limit(amount)
                .toList();

        return Flux.fromIterable(names)
                .delayElements(Duration.ofSeconds(1));
    }
}
