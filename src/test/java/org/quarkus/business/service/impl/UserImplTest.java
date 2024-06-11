package org.quarkus.business.service.impl;

import io.quarkus.mongodb.panache.reactive.ReactivePanacheQuery;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.helpers.test.UniAssertSubscriber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.quarkus.business.document.User;
import org.quarkus.business.respository.UserRepository;
import org.mockito.Mockito;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserImplTest {

    @InjectMocks
    UserImpl userImplMock;

    @Mock
    UserRepository userRepositoryMock;

    @Test
    @DisplayName("Given no users, when retrieving users, then should return empty list")
    void givenNoUsersWhenRetrievingUsersThenShouldReturnEmptyList() {
        // Arrange (Given)
        ReactivePanacheQuery<User> queryMock = Mockito.mock(ReactivePanacheQuery.class);
        when(queryMock.list()).thenReturn(Uni.createFrom().item(Collections.emptyList()));
        when(userRepositoryMock.find(Mockito.any())).thenReturn((queryMock));

        // Act (When)
        Uni<List<User>> result = userImplMock.findInfluencers("test");

        // Assert (Then)
        UniAssertSubscriber<List<User>> subscriber = result.subscribe().withSubscriber(UniAssertSubscriber.create());
        subscriber.assertItem(Collections.emptyList());
    }

    @Test
    @DisplayName("Given users, when retrieving users, then should return user list")
    void givenUsersWhenRetrievingUsersThenShouldReturnUserList() {
        // Arrange (Given)
        List<User> userList = Arrays.asList(new User("user1name", "user1url", "user1type"), new User("user2type", "user2type", "user2type")); // Crea una lista de usuarios de prueba
        ReactivePanacheQuery<User> queryMock = Mockito.mock(ReactivePanacheQuery.class);
        when(queryMock.list()).thenReturn(Uni.createFrom().item(userList)); // Configura el mock para que devuelva la lista de usuarios de prueba
        when(userRepositoryMock.find(Mockito.any())).thenReturn(queryMock);

        // Act (When)
        Uni<List<User>> result = userImplMock.findInfluencers("test");

        // Assert (Then)
        UniAssertSubscriber<List<User>> subscriber = result.subscribe().withSubscriber(UniAssertSubscriber.create());
        subscriber.assertItem(userList); // Verifica que la lista de usuarios devuelta es igual a la lista de usuarios de prueba
    }


    @Test
    @DisplayName("Given an exception, when retrieving users, then should throw exception")
    void givenExceptionWhenRetrievingUsersThenShouldThrowException() {
        // Arrange (Given)
        ReactivePanacheQuery<User> queryMock = Mockito.mock(ReactivePanacheQuery.class);
        when(queryMock.list()).thenReturn(Uni.createFrom().failure(new RuntimeException("Test exception"))); // Configura el mock para que lance una excepción
        when(userRepositoryMock.find(Mockito.any())).thenReturn(queryMock);

        // Act (When)
        Uni<List<User>> result = userImplMock.findInfluencers("test");

        // Assert (Then)
        UniAssertSubscriber<List<User>> subscriber = result.subscribe().withSubscriber(UniAssertSubscriber.create());
        subscriber.assertFailedWith(RuntimeException.class, "Test exception"); // Verifica que se produce una RuntimeException con el mensaje "Test exception"
    }

}