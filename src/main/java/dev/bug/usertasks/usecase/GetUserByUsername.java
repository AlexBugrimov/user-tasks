package dev.bug.usertasks.usecase;

import dev.bug.usertasks.domain.user.User;
import java.util.Optional;

public interface GetUserByUsername {

    Optional<User> execute(String username);
}
