package com.company.uberApp.Uber.services;

import com.company.uberApp.Uber.dto.DriverDto;
import com.company.uberApp.Uber.dto.RideDto;
import com.company.uberApp.Uber.dto.RiderDto;
import com.company.uberApp.Uber.entities.Driver;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface DriverService {


    RideDto acceptRide(Long rideRequestId);
    RideDto cancelRide(Long rideId);

    RideDto startRide(Long rideId, String otp);
    RideDto endRide(Long rideId);
    RiderDto rateRider(Long rideId, Integer rating);

    DriverDto getMyProfile();
    Page<RideDto> getAllMyRides(PageRequest pageRequest);

    Driver getCurrentDriver();

    Driver updateDriverAvailability(Driver driver, boolean available);
    Driver createNewDriver(Driver driver);
}
