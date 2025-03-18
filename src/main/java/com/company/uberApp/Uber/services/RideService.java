package com.company.uberApp.Uber.services;

import com.company.uberApp.Uber.entities.Driver;
import com.company.uberApp.Uber.entities.Ride;
import com.company.uberApp.Uber.entities.RideRequest;
import com.company.uberApp.Uber.entities.Rider;
import com.company.uberApp.Uber.entities.enums.RideStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface RideService {

    Ride getRideById(Long rideId);
    Ride createNewRide(RideRequest rideRequest, Driver savedDriver);

    Ride updateRideStatus(Ride ride, RideStatus rideStatus);

    Page<Ride> getAllRidesOfRider(Rider rider, PageRequest pageRequest);
    Page<Ride> getAllRidesOfDriver(Driver driver, PageRequest pageRequest);
}
