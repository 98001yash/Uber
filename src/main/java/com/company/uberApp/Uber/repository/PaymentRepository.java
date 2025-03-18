package com.company.uberApp.Uber.repository;

import com.company.uberApp.Uber.entities.Payment;
import com.company.uberApp.Uber.entities.Ride;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment,Long> {
    Optional<Payment> findByRide(Ride ride);
}
