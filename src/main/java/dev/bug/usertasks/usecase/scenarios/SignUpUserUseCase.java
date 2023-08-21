package dev.bug.usertasks.usecase.scenarios;

import dev.bug.usertasks.domain.user.User;
import dev.bug.usertasks.persistence.Role;
import dev.bug.usertasks.usecase.SignUpUser;
import dev.bug.usertasks.usecase.access.UserPersisted;
import dev.bug.usertasks.usecase.access.UsersExtractor;
import java.time.LocalDate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public record SignUpUserUseCase(
    UsersExtractor usersExtractor,
    UserPersisted userPersisted,
    PasswordEncoder passwordEncoder
) implements SignUpUser {

    @Override
    public void execute(String name,
                        String username,
                        String phone,
                        String email,
                        LocalDate birthDate,
                        String password) {
        var user = usersExtractor.findByUsername(username);
        if (user.isEmpty()) {
            userPersisted.save(
                User.of(name, username, phone, email, birthDate, passwordEncoder().encode(password),
                    Role.USER)
            );
        }
    }
}
