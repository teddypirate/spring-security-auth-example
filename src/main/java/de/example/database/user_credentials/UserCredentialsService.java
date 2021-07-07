package de.example.database.user_credentials;


import java.util.Optional;

public interface UserCredentialsService {

    Optional<UserCredentials> getByUsername(String username);
}
