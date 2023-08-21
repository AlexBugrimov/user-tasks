package dev.bug.usertasks.view;

import dev.bug.usertasks.usecase.GetUserByUsername;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public record UserAuthenticationService(
    GetUserByUsername getUserByUsername
) implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return getUserByUsername.execute(username)
            .map(UserSecurityDetails::new)
            .orElseThrow(() -> new UsernameNotFoundException(
                "User with username '%s' not found".formatted(username)));
    }
}
