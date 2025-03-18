package com.company.uberApp.Uber.services.impl;


import com.company.uberApp.Uber.dto.DriverDto;
import com.company.uberApp.Uber.dto.RiderDto;
import com.company.uberApp.Uber.entities.Driver;
import com.company.uberApp.Uber.entities.Rating;
import com.company.uberApp.Uber.entities.Ride;
import com.company.uberApp.Uber.entities.Rider;
import com.company.uberApp.Uber.exceptions.ResourceNotFoundException;
import com.company.uberApp.Uber.exceptions.RuntimeConflictException;
import com.company.uberApp.Uber.repository.DriverRepository;
import com.company.uberApp.Uber.repository.RatingRepository;
import com.company.uberApp.Uber.repository.RideRepository;
import com.company.uberApp.Uber.repository.RiderRepository;
import com.company.uberApp.Uber.services.RatingService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RatingServiceImpl implements RatingService {

    private final ModelMapper modelMapper;
    private final RatingRepository ratingRepository;
    private final DriverRepository driverRepository;
    private final RiderRepository riderRepository;
    @Override
    public DriverDto rateDriver(Ride ride, Integer rating) {
        Driver driver = ride.getDriver();
        Rating ratingObj = ratingRepository.findByRide(ride)
                .orElseThrow(()->new ResourceNotFoundException("Rating not found with id: "+ride.getId()));

        if(ratingObj.getDriverRating()!=null)
            throw new RuntimeConflictException("Driver has already been rated cannot rate again..");


        ratingObj.setDriverRating(rating);

        ratingRepository.save(ratingObj);
        Double newRating =  ratingRepository.findByDriver(driver)
                .stream()
                .mapToDouble(Rating:: getDriverRating)
                .average().orElse(0.0);
        driver.setRating(newRating);

        Driver savedDriver = driverRepository.save(driver);
        return modelMapper.map(savedDriver,DriverDto.class);
    }

    @Override
    public RiderDto rateRider(Ride ride, Integer rating) {
        Rider rider = ride.getRider();
        Rating ratingObj = ratingRepository.findByRide(ride)
                .orElseThrow(()->new ResourceNotFoundException("Rating not found with id: "+ride.getId()));

        if(ratingObj.getRiderRating()!=null)
            throw new RuntimeConflictException("Rider has already been rated caanot rate again..");


        ratingObj.setRiderRating(rating);

        ratingRepository.save(ratingObj);
        Double newRating =  ratingRepository.findByRider(rider)
                .stream()
                .mapToDouble(Rating:: getRiderRating)
                .average().orElse(0.0);
        rider.setRating(newRating);

        Rider savedRider = riderRepository.save(rider);
        return modelMapper.map(savedRider, RiderDto.class);
    }

    @Override
    public void createNewRating(Ride ride) {
        Rating rating = Rating.builder()
                .rider(ride.getRider())
                .driver(ride.getDriver())
                .ride(ride)
                .build();
        ratingRepository.save(rating);
    }
}
