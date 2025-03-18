package com.company.uberApp.Uber.strategies;

import com.company.uberApp.Uber.entities.Driver;
import com.company.uberApp.Uber.entities.RideRequest;

import java.util.List;

public interface DriverMatchingStrategy {

    List<Driver> findMatchingDriver(RideRequest rideRequest);
}
