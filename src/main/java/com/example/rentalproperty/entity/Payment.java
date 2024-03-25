package com.example.rentalproperty.entity;

import com.example.rentalproperty.entity.enums.PaymentStatus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class Payment {
    private UUID id;
    private Contract contract;
    private BigDecimal amount;
    private LocalDate paymentDate;
    private PaymentStatus paymentStatus;
}
