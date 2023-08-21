package dev.bug.usertasks.persistence;

import dev.bug.usertasks.domain.user.User;
import dev.bug.usertasks.usecase.access.UserPersisted;
import dev.bug.usertasks.usecase.access.UsersExtractor;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public record UserRepository(UserCrudRepository repository)
    implements UsersExtractor, UserPersisted {

    @Override
    public Optional<User> findByUsername(String username) {
        return repository.findByUsername(username)
            .map(UserEntity::toModel);
    }

    @Override
    public void save(User user) {
        repository.save(UserEntity.toEntity(user));
    }
}
