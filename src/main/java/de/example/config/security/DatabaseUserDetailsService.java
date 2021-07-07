package de.example.config.security;

import de.example.database.user_credentials.UserCredentials;
import de.example.database.user_credentials.UserCredentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DatabaseUserDetailsService implements UserDetailsService {

    private final UserCredentialsService userCredentialsService;

    @Autowired
    public DatabaseUserDetailsService(final UserCredentialsService userCredentialsService) {
        this.userCredentialsService = userCredentialsService;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        UserCredentials userCredentials = userCredentialsService.getByUsername(username).orElseThrow(() -> new UsernameNotFoundException("no user_credentials found for username '"+username+"'"));
        return User.withUsername(userCredentials.getUsername())
                .password(userCredentials.getPassword())
                .roles("USER")
                .build();
    }
}
