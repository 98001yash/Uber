package com.company.uberApp.Uber.services;

import com.company.uberApp.Uber.dto.DriverDto;
import com.company.uberApp.Uber.dto.RiderDto;
import com.company.uberApp.Uber.entities.Ride;

public interface RatingService {

    DriverDto rateDriver(Ride ride, Integer rating);
    RiderDto rateRider(Ride ride, Integer rating);

    void createNewRating(Ride ride);
}
