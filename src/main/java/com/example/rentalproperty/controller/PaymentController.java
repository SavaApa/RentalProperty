package com.example.rentalproperty.controller;

import com.example.rentalproperty.dto.PaymentAfterCreatingDto;
import com.example.rentalproperty.dto.PaymentCreateDto;
import com.example.rentalproperty.entity.Payment;
import com.example.rentalproperty.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payment")
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping("/create")
    public PaymentAfterCreatingDto createPayment(@RequestBody PaymentCreateDto paymentCreateDto){
        return paymentService.createPayment(paymentCreateDto);
    }

}
