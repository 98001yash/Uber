package com.company.uberApp.Uber.services;

import com.company.uberApp.Uber.entities.RideRequest;

public interface RideRequestService {

    RideRequest findRideRequestById(Long rideRequestId);
    void update(RideRequest rideRequest);
}
