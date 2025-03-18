package com.company.uberApp.Uber.strategies;

import com.company.uberApp.Uber.entities.enums.PaymentMethod;
import com.company.uberApp.Uber.strategies.impl.CashPaymentStrategy;
import com.company.uberApp.Uber.strategies.impl.WalletPaymentStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class PaymentStrategyManager {

    private final WalletPaymentStrategy walletPaymentStrategy;
    private final CashPaymentStrategy cashPaymentStrategy;

    public PaymentStrategy paymentStrategy(PaymentMethod paymentMethod) {
        return switch(paymentMethod){
            case WALLET ->walletPaymentStrategy;
            case CASH ->cashPaymentStrategy;
        };
    }
}

