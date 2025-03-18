package com.company.uberApp.Uber.services;

import com.company.uberApp.Uber.entities.Ride;
import com.company.uberApp.Uber.entities.User;
import com.company.uberApp.Uber.entities.Wallet;
import com.company.uberApp.Uber.entities.enums.TransactionMethod;

public interface WalletService {

    Wallet addMoneyToWallet(User user, Double amount,
                            String transactionId, Ride ride,
                            TransactionMethod transactionMethod);

    Wallet deductMoneyFromWallet(User user, Double amount,
                                 String transactionId, Ride ride,
                                 TransactionMethod transactionMethod);
    void WithdrawAllMyMoneyFromWallet();

    Wallet findWalletById(Long walletId);

    Wallet createNewWallet(User user);
    Wallet findByUser(User user);
}