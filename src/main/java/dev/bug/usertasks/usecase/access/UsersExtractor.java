package dev.bug.usertasks.usecase.access;

import dev.bug.usertasks.domain.user.User;
import java.util.Optional;

public interface UsersExtractor {

    Optional<User> findByUsername(String username);
}
