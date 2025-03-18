package com.company.uberApp.Uber.strategies;

import com.company.uberApp.Uber.entities.Payment;

public interface PaymentStrategy {

    Double PLATFORM_COMMISSION = 0.3;
    void processPayment(Payment payment);


}
