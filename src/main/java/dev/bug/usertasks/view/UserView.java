package dev.bug.usertasks.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserView {

    private String name;
    private String username;
    private String phone;
    private String email;
    private String birthDate;
    private String password;
}
