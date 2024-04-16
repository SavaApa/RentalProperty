package com.example.rentalproperty.service.impl;

import com.example.rentalproperty.dto.PaymentAfterCreatingDto;
import com.example.rentalproperty.dto.PaymentCreateDto;
import com.example.rentalproperty.entity.Payment;
import com.example.rentalproperty.mapper.PaymentMapper;
import com.example.rentalproperty.repository.PaymentRepository;
import com.example.rentalproperty.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;
    @Override
    public PaymentAfterCreatingDto createPayment(PaymentCreateDto paymentCreateDto) {
        Payment payment = paymentRepository.findByPaymentStatus(paymentCreateDto.getStatus().toString());
        if(payment != null){
            throw new NullPointerException();
        }

        Payment entity = paymentMapper.toEntity(paymentCreateDto);
        Payment paymentAfterCreation = paymentRepository.save(entity);
        return paymentMapper.toDto(paymentAfterCreation);
    }
}
