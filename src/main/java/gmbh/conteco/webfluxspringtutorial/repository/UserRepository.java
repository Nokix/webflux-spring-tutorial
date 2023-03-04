package gmbh.conteco.webfluxspringtutorial.repository;

import gmbh.conteco.webfluxspringtutorial.entity.User;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;

public interface UserRepository extends R2dbcRepository<User, Long> {
    @Query("SELECT * FROM USERS WHERE USERS.first_name = ?1 OR USERS.last_name = ?1")
    Flux<User> getUserByName(String name);
}
