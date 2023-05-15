package com.pragma.powerup.usermicroservice.domain.spi;

import com.pragma.powerup.usermicroservice.domain.model.Restaurant;
import org.springframework.http.ResponseEntity;

public interface IRestaurantPersistencePort {
    ResponseEntity<String> createRestaurant(Restaurant restaurant);
}
