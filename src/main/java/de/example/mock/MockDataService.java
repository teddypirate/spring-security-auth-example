package de.example.mock;

import de.example.database.user_credentials.UserCredentials;
import de.example.database.user_credentials.UserCredentialsRepository;
import de.example.database.user_credentials.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MockDataService {

    private final UserCredentialsRepository userCredentialsRepository;
    private final PasswordEncoder encoder;
    private final MongoTemplate template;

    @Autowired
    public MockDataService(final UserCredentialsRepository userCredentialsRepository,
                           final PasswordEncoder encoder,
                           final MongoTemplate template) {
        this.userCredentialsRepository = userCredentialsRepository;
        this.encoder = encoder;
        this.template = template;
    }

    @PostConstruct
    public void init() {
        initCredentials();
    }

    private void initCredentials() {
        template.dropCollection(UserCredentials.class);
        template.createCollection(UserCredentials.class);
        UserCredentials userCred1 = UserCredentials.builder()
                .enabled(true)
                .username("teddypirate")
                .password(encoder.encode("password"))
                .role(UserRole.USER)
                .build();
        userCredentialsRepository.save(userCred1);
        UserCredentials userCred2 = UserCredentials.builder()
                .enabled(true)
                .username("thefh")
                .password(encoder.encode("password"))
                .role(UserRole.USER)
                .build();
        userCredentialsRepository.save(userCred2);
    }
}
