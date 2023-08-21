package dev.bug.usertasks.persistence;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface UserCrudRepository extends CrudRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsername(String username);
}
