package org.quarkus.business.document;

import io.quarkus.mongodb.panache.common.MongoEntity;
import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.util.List;

@MongoEntity(collection = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User extends ReactivePanacheMongoEntity {
    public String userName;
    public String urlAvatar;
    public String type;
}
