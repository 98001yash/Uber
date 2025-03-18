package com.company.uberApp.Uber.repository;

import com.company.uberApp.Uber.entities.RideRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RideRequestRepository extends JpaRepository<RideRequest, Long> {
}
