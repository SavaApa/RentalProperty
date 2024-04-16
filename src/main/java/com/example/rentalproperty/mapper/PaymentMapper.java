package com.example.rentalproperty.mapper;

import com.example.rentalproperty.dto.PaymentAfterCreatingDto;
import com.example.rentalproperty.dto.PaymentCreateDto;
import com.example.rentalproperty.entity.Payment;
import com.example.rentalproperty.entity.enums.PaymentStatus;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PaymentMapper {
    Payment toEntity(PaymentCreateDto paymentCreateDto);

    PaymentAfterCreatingDto toDto(Payment paymentAfterCreation);

}
