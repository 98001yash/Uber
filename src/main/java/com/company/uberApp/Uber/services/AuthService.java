package com.company.uberApp.Uber.services;

import com.company.uberApp.Uber.dto.DriverDto;
import com.company.uberApp.Uber.dto.SignUpDto;
import com.company.uberApp.Uber.dto.UserDto;

public interface AuthService {

    String[] login(String email, String password);
    UserDto signup(SignUpDto signUpDto);
    DriverDto onboardNewDriver(Long userId, String vehicleId);
    String refreshToken(String refreshToken);
}
