package com.company.uberApp.Uber.services;

import com.company.uberApp.Uber.entities.Payment;
import com.company.uberApp.Uber.entities.Ride;
import com.company.uberApp.Uber.entities.enums.PaymentStatus;

public interface PaymentService {

    void processPayment(Ride ride);

    Payment createNewPayment(Ride ride);
    void updatePaymentStatus(Payment payment, PaymentStatus status);
}
