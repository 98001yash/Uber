package com.company.uberApp.Uber.repository;

import com.company.uberApp.Uber.entities.Rider;
import com.company.uberApp.Uber.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RiderRepository extends JpaRepository<Rider, Long> {
    Optional<Rider> findByUser(User user);
}
