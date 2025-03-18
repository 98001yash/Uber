package com.company.uberApp.Uber.strategies.impl;

import com.company.uberApp.Uber.entities.Driver;
import com.company.uberApp.Uber.entities.RideRequest;
import com.company.uberApp.Uber.repository.DriverRepository;
import com.company.uberApp.Uber.strategies.DriverMatchingStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DriverMatchingNearestDriverStrategy implements DriverMatchingStrategy {

    private final DriverRepository driverRepository;

    @Override
    public List<Driver> findMatchingDriver(RideRequest rideRequest) {
        return driverRepository.findTenNearestDrivers(rideRequest.getPickupLocation());
    }
}
