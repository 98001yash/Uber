package com.company.uberApp.Uber.repository;

import com.company.uberApp.Uber.entities.Ride;
import com.company.uberApp.Uber.entities.Rider;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RideRepository extends JpaRepository<Ride,Long> {

    Page<Ride> findByRider(Rider rider, Pageable pageRequest);
}
