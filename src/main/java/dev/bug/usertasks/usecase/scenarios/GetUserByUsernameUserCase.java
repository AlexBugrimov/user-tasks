package dev.bug.usertasks.usecase.scenarios;

import dev.bug.usertasks.domain.user.User;
import dev.bug.usertasks.usecase.GetUserByUsername;
import dev.bug.usertasks.usecase.access.UsersExtractor;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public record GetUserByUsernameUserCase(UsersExtractor usersExtractor)
    implements GetUserByUsername {

    @Override
    public Optional<User> execute(String username) {
        return usersExtractor.findByUsername(username);
    }
}
