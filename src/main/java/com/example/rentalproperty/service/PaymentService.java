package com.example.rentalproperty.service;

import com.example.rentalproperty.dto.PaymentAfterCreatingDto;
import com.example.rentalproperty.dto.PaymentCreateDto;

public interface PaymentService {
    PaymentAfterCreatingDto createPayment(PaymentCreateDto paymentCreateDto);
}
