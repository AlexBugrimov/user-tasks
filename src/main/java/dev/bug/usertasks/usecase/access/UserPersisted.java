package dev.bug.usertasks.usecase.access;

import dev.bug.usertasks.domain.user.User;

public interface UserPersisted {

    void save(User user);
}
