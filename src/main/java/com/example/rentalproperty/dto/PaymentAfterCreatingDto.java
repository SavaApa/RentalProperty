package com.example.rentalproperty.dto;

import lombok.Data;

@Data
public class PaymentAfterCreatingDto {
    private String paymentId;
    private String status = "PAYMENT CREATED";
}
