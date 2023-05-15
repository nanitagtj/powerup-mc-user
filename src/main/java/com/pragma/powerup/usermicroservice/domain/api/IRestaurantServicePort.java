package com.pragma.powerup.usermicroservice.domain.api;

import com.pragma.powerup.usermicroservice.domain.model.Restaurant;
import org.springframework.http.ResponseEntity;

public interface IRestaurantServicePort {
    ResponseEntity<String> createRestaurant(Restaurant restaurant);
}
