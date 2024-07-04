package com.artha.handler;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.artha.entity.Users;
import com.artha.service.UserService;

public class FindAllUsersFunctionTest {

    @Mock
    private UserService userService;

    @Mock
    private Context lambdaContext;

    @Mock
    private LambdaLogger lambdaLogger;

    @InjectMocks
    private FindAllUsersFunction findAllUsersFunction;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        when(lambdaContext.getLogger()).thenReturn(lambdaLogger);
    }

    @Test
    public void testHandleRequest() {
        // Given
        Users user1 = new Users();
        user1.setFirstName("John");
        user1.setLastName("Doe");

        Users user2 = new Users();
        user2.setFirstName("Jane");
        user2.setLastName("Doe");

        List<Users> expectedUsers = Arrays.asList(user1, user2);

        // When
        when(userService.findAll()).thenReturn(expectedUsers);

        // Then
        List<Users> result = findAllUsersFunction.handleRequest(null, lambdaContext);
        assertThat(result).isEqualTo(expectedUsers);
    }
}
