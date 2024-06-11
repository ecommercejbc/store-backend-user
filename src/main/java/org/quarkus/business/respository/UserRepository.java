package org.quarkus.business.respository;

import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoRepository;
import jakarta.inject.Singleton;
import org.quarkus.business.document.User;

@Singleton
public class UserRepository implements ReactivePanacheMongoRepository<User> {


}
