package com.company.uberApp.Uber.repository;

import com.company.uberApp.Uber.entities.Rider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RiderRepository extends JpaRepository<Rider, Long> {
}
