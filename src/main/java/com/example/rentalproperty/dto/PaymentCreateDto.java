package com.example.rentalproperty.dto;

import com.example.rentalproperty.entity.enums.PaymentStatus;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDate;

@Value
public class PaymentCreateDto {

    private BigDecimal amount;

    private LocalDate paymentDate;

    private PaymentStatus status;
}
