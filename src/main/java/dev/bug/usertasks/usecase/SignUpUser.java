package dev.bug.usertasks.usecase;

import java.time.LocalDate;

public interface SignUpUser {

    void execute(String name,
                 String username,
                 String phone,
                 String email,
                 LocalDate birthDate,
                 String password);
}
