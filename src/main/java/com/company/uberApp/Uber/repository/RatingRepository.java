package com.company.uberApp.Uber.repository;

import com.company.uberApp.Uber.entities.Driver;
import com.company.uberApp.Uber.entities.Rating;
import com.company.uberApp.Uber.entities.Ride;
import com.company.uberApp.Uber.entities.Rider;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface RatingRepository extends JpaRepository<Rating,Long> {

    List<Rating> findByDriver(Driver driver);
    Optional<Rating> findByRide(Ride ride);

    Optional<Rating> findByRider(Rider rider);

}
