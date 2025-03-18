package com.company.uberApp.Uber.repository;

import com.company.uberApp.Uber.entities.WalletTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletTransactionRepository  extends JpaRepository<WalletTransaction,Long> {
}
