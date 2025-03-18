package com.company.uberApp.Uber.repository;

import com.company.uberApp.Uber.entities.User;
import com.company.uberApp.Uber.entities.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WalletRepository extends JpaRepository<Wallet,Long> {

    Optional<Wallet> findByUser(User user);
}