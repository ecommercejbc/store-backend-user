package org.quarkus.business.service.impl;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.infrastructure.Infrastructure;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.openapitools.client.ApiResponse;
import org.openapitools.client.model.CategoryRequestDTO;
import org.quarkus.business.document.User;
import org.quarkus.business.respository.UserRepository;
import org.quarkus.business.service.UserService;
import org.quarkus.business.utils.Constants;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Singleton
public class UserImpl implements UserService {

    @Inject
    UserRepository userRepository;


    /**
     * VERSION 1
     */


    //@Override
    public Uni<ApiResponse<List<User>>> findInfluencersv1(String influencerName) {
        Document document = new Document();
        document.append("userName", java.util.regex.Pattern.compile(influencerName, java.util.regex.Pattern.CASE_INSENSITIVE));
        return userRepository.find(document)
                .list()
                .onItem().transform(list -> list.stream().limit(8).collect(Collectors.toList())) // Toma los primeros 8 elementos
                .onItem().transformToUni(users -> {
                    if (users.isEmpty()) {
                        return Uni.createFrom().item(new ApiResponse<>(204, new HashMap<>(), null)); // Devuelve 204 si no hay usuarios
                    } else {
                        return Uni.createFrom().item(new ApiResponse<>(200, new HashMap<>(), users)); // Envuelve la lista de usuarios en un ApiResponse
                    }
                });
    }


    /**
     * VERSION 2
     */
    public Uni<ApiResponse<List<User>>> findInfluencersV2(String influencerName) {
        return userRepository.find(createSearchDocument(influencerName))
                .list()
                .onItem().transform(this::limitResults)
                .onItem().transformToUni(this::createApiResponse);
    }

    private Document createSearchDocument(String influencerName) {
        Document document = new Document();
        document.append("userName", java.util.regex.Pattern.compile(influencerName, java.util.regex.Pattern.CASE_INSENSITIVE));
        return document;
    }

    private List<User> limitResults(List<User> users) {
        return users.stream().limit(Constants.MAX_RESULTS).collect(Collectors.toList());
    }

    private Uni<ApiResponse<List<User>>> createApiResponse(List<User> users) {
        if (users.isEmpty()) {
            return Uni.createFrom().item(new ApiResponse<>(204, new HashMap<>(), null));
        } else {
            return Uni.createFrom().item(new ApiResponse<>(200, new HashMap<>(), users));
        }
    }


    //@Override
    public Uni<List<User>> findInfluencersv3(String influencerName) {
        Document document = new Document();
        document.append("userName", java.util.regex.Pattern.compile(influencerName, java.util.regex.Pattern.CASE_INSENSITIVE));
        return userRepository.find(document)
                .list()
                .onItem().transform(list -> list.stream().limit(8).collect(Collectors.toList())); // Toma los primeros 8 elementos
    }

    /**
     * VERSION 3
     */
    @Override
    public Uni<List<User>> findInfluencers(String influencerName) {
        return userRepository.find(createSearchDocument(influencerName))
                .list()
                .onItem().transform(this::limitResults);// Toma los primeros 8 elementos
    }

    @Override
    public Uni<User> findById(ObjectId id) {
        return userRepository.findById(id);
    }

}
