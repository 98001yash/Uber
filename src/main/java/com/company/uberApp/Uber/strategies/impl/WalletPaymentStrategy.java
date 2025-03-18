package com.company.uberApp.Uber.strategies.impl;

import com.company.uberApp.Uber.entities.Driver;
import com.company.uberApp.Uber.entities.Payment;
import com.company.uberApp.Uber.entities.Rider;
import com.company.uberApp.Uber.entities.enums.PaymentStatus;
import com.company.uberApp.Uber.entities.enums.TransactionMethod;
import com.company.uberApp.Uber.repository.PaymentRepository;
import com.company.uberApp.Uber.services.WalletService;
import com.company.uberApp.Uber.strategies.PaymentStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class WalletPaymentStrategy implements PaymentStrategy {

    private final WalletService walletService;
    private final PaymentRepository paymentRepository;


    @Override
    @Transactional
    public void processPayment(Payment payment) {
        Driver driver = payment.getRide().getDriver();
        Rider rider = payment.getRide().getRider();

        walletService.deductMoneyFromWallet(rider.getUser(),
                payment.getAmount(), null,payment.getRide(), TransactionMethod.RIDE);

        double driversCut = payment.getAmount() * (1 - PLATFORM_COMMISSION);

        walletService.addMoneyToWallet(driver.getUser(),
                driversCut,null,payment.getRide(),TransactionMethod.RIDE);


        payment.setPaymentStatus(PaymentStatus.CONFIRMED);
        paymentRepository.save(payment);
    }
}
