package de.example.database.user_credentials;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserCredentialsRepository extends MongoRepository<UserCredentials, ObjectId> {

    UserCredentials findByUsername(String username);
}