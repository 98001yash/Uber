package com.company.uberApp.Uber.strategies.impl;

import com.company.uberApp.Uber.entities.Driver;
import com.company.uberApp.Uber.entities.Payment;
import com.company.uberApp.Uber.entities.Wallet;
import com.company.uberApp.Uber.entities.enums.PaymentStatus;
import com.company.uberApp.Uber.entities.enums.TransactionMethod;
import com.company.uberApp.Uber.repository.PaymentRepository;
import com.company.uberApp.Uber.services.WalletService;
import com.company.uberApp.Uber.strategies.PaymentStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CashPaymentStrategy implements PaymentStrategy {

    private final WalletService walletService;
    private final PaymentRepository paymentRepository;


    @Override
    public void processPayment(Payment payment) {
        Driver driver = payment.getRide().getDriver();

        Wallet driverWallet = walletService.findByUser(driver.getUser());
        double platformCommission =payment.getAmount() * PLATFORM_COMMISSION;

        walletService.deductMoneyFromWallet(driver.getUser(),platformCommission,null,
                payment.getRide(), TransactionMethod.RIDE);

        payment.setPaymentStatus(PaymentStatus.CONFIRMED);
        paymentRepository.save(payment);
    }
}