package com.pragma.powerup.usermicroservice.adapters.driving.http.controller;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.UserRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.IUserHandler;
import com.pragma.powerup.usermicroservice.configuration.Constants;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserRestControllerTest {

    @Test
    public void createOwner_WhenValidUserRequestDto_ReturnsCreatedResponse() {
        UserRequestDto userRequestDto = new UserRequestDto();
        IUserHandler userHandlerMock = Mockito.mock(IUserHandler.class);
        UserRestController userRestController = new UserRestController(userHandlerMock);

        ResponseEntity<Map<String, String>> response = userRestController.createOwner(userRequestDto);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(Constants.USER_CREATED_MESSAGE, response.getBody().get(Constants.RESPONSE_MESSAGE_KEY));
        verify(userHandlerMock, times(1)).createOwner(userRequestDto);
    }

}