package dev.bug.usertasks.domain.user;

import dev.bug.usertasks.persistence.Role;
import java.time.LocalDate;

public record User(String name,
                   String username,
                   String phone,
                   String email,
                   LocalDate birthDate,
                   String password,
                   Role role) {

    public static User of(String name,
                          String username,
                          String phone,
                          String email,
                          LocalDate birthDate,
                          String password,
                          Role role) {
        return new User(name, username, phone, email, birthDate, password, role);
    }
}
