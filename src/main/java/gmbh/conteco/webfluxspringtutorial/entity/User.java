package gmbh.conteco.webfluxspringtutorial.entity;

import lombok.*;
import org.springframework.data.annotation.Id;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    public Long id;
    public String firstName;
    public String lastName;
}
