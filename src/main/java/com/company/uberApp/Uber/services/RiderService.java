package com.company.uberApp.Uber.services;

import com.company.uberApp.Uber.dto.DriverDto;
import com.company.uberApp.Uber.dto.RideDto;
import com.company.uberApp.Uber.dto.RideRequestDto;
import com.company.uberApp.Uber.dto.RiderDto;
import com.company.uberApp.Uber.entities.Rider;
import com.company.uberApp.Uber.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface RiderService {

    RideRequestDto requestRide(RideRequestDto rideRequestDto);
    RideDto cancelRide(Long rideId);
    DriverDto rateDriver(Long rideId, Integer rating);
    RiderDto getMyProfile();

    Page<RideDto> getAllMyRides(PageRequest pageRequest);
    Rider createNewRider(User user);
    Rider getCurrentRider();
}
