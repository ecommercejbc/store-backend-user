package org.quarkus.business.controller;

import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.bson.types.ObjectId;
import org.jboss.resteasy.reactive.RestResponse;
import org.openapitools.client.ApiResponse;
import org.quarkus.business.document.User;
import org.quarkus.business.service.UserService;
import org.quarkus.business.utils.ResponseUtil;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/v1/user")
public class UserController {

    @Inject
    UserService userService;

    /**
     * VERSION 4
     */
    //@GET
    //@Path("/influencers/{name}")
    public Uni<Response> findInfluencers4(@PathParam("name") String influencerName) {
        return userService.findInfluencers(influencerName)
                .onItem().transform(users -> {
                    if (users.isEmpty()) {
                        return Response.status(204).build(); // Devuelve 204 si no hay usuarios
                    } else {
                        return Response.ok(new ApiResponse<>(200, new HashMap<>(), users)).build(); // Envuelve la lista de usuarios en un ApiResponse
                    }
                })
                .onFailure().recoverWithItem(throwable -> {
                    Map<String, List<String>> errorHeaders = new HashMap<>();
                    errorHeaders.put("Error-Message", Collections.singletonList(throwable.getMessage()));
                    return Response.status(500).entity(new ApiResponse<List<User>>(500, errorHeaders, null)).build();
                });
    }


    /**
     * VERSION 6
     */
    @GET
    @Path("/influencers/{name}")
    public Uni<Response> findInfluencers6(@PathParam("name") String influencerName) {
        return userService.findInfluencers(influencerName)
                .onItem().transform(ResponseUtil::buildResponseList)
                .onFailure().recoverWithItem(ResponseUtil::handleError);
    }


    @GET
    @Path("/influencers/id/{id}")
    public Uni<Response> findUserById(@PathParam("id") String id) {
        return userService.findById(new ObjectId(id))
                .onItem().transform(ResponseUtil::buildResponseObject)
                .onFailure().recoverWithItem(ResponseUtil::handleError);
    }


}
