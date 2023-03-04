package gmbh.conteco.webfluxspringtutorial.controller;

import gmbh.conteco.webfluxspringtutorial.service.UserService;
import gmbh.conteco.webfluxspringtutorial.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public Flux<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/users/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Flux<User> createNewUsers(
            @RequestParam(defaultValue = "10") int amount
    ) {
        return userService.createNewUsers(amount);
    }

    @GetMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<User> getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @GetMapping("/users/")
    @ResponseStatus(HttpStatus.OK)
    public Flux<User> getUserByName(@RequestParam String name){
        return userService.getUserByName(name);
    }
}
