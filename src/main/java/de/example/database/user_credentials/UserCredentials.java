package de.example.database.user_credentials;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection=  "user_credentials")
public class UserCredentials {

    private ObjectId id;

    @Id
    private String username;

    private String password;

    @Singular("role")
    private Set<UserRole> roles;

    boolean enabled;
}