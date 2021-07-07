package de.example.database.user_credentials;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserCredentialsServiceImpl implements UserCredentialsService {

    @NonNull
    private final UserCredentialsRepository repository;

    @Override
    public Optional<UserCredentials> getByUsername(String username) {
        return Optional.ofNullable(repository.findByUsername(username));
    }
}
