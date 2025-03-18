package com.company.uberApp.Uber.strategies.impl;

import com.company.uberApp.Uber.entities.Driver;
import com.company.uberApp.Uber.entities.RideRequest;
import com.company.uberApp.Uber.repository.DriverRepository;
import com.company.uberApp.Uber.strategies.DriverMatchingStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional()
public class DriverMatchingHighestRatedDriverStrategy implements DriverMatchingStrategy {

    private final DriverRepository driverRepository;

    @Override
    public List<Driver> findMatchingDriver(RideRequest rideRequest) {
        return driverRepository.findTenNearbyTopRatedDrivers(rideRequest.getPickupLocation());
    }
}
