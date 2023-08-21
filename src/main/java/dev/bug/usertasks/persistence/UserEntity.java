package dev.bug.usertasks.persistence;

import dev.bug.usertasks.domain.user.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String name;
    @Column(unique = true)
    private String username;
    private String email;
    private String phone;
    private LocalDate birthDate;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    private LocalDateTime createdAt;

    public static UserEntity toEntity(User user) {
        return new UserEntity(
            null,
            user.name(),
            user.username(),
            user.email(),
            user.phone(),
            user.birthDate(),
            user.password(),
            Role.USER,
            LocalDateTime.now()
        );
    }

    public User toModel() {
        return new User(
            name,
            username,
            email,
            phone,
            birthDate,
            password,
            role
        );
    }
}
