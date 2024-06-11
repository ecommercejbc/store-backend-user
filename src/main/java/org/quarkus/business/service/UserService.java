package org.quarkus.business.service;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import org.bson.types.ObjectId;
import org.openapitools.client.ApiResponse;
import org.openapitools.client.model.CategoryRequestDTO;
import org.quarkus.business.document.User;

import java.util.List;

public interface UserService {

    Uni<List<User>> findInfluencers(String influencerName);
    Uni<User> findById(ObjectId id);


}

