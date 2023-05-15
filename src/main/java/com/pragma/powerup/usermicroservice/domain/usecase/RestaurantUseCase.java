package com.pragma.powerup.usermicroservice.domain.usecase;

import com.pragma.powerup.usermicroservice.domain.api.IRestaurantServicePort;
import com.pragma.powerup.usermicroservice.domain.model.Restaurant;
import com.pragma.powerup.usermicroservice.domain.spi.IRestaurantPersistencePort;
import com.pragma.powerup.usermicroservice.domain.validations.Validations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class RestaurantUseCase implements IRestaurantServicePort {
    private final IRestaurantPersistencePort restaurantPersistencePort;

    public RestaurantUseCase(IRestaurantPersistencePort personPersistencePort) {
        this.restaurantPersistencePort = personPersistencePort;
    }

    @Override
    public ResponseEntity<String> createRestaurant(Restaurant restaurant) {
        try {
            Validations.validateName(restaurant.getName());
        } catch (IllegalArgumentException e) {
            String errorMessage = e.getMessage();
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        }

        restaurantPersistencePort.createRestaurant(restaurant);

        return new ResponseEntity<>("Restaurant created successfully", HttpStatus.OK);
    }
}
