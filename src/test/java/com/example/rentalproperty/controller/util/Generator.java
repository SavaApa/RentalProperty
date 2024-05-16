package com.example.rentalproperty.controller.util;

import com.example.rentalproperty.entity.*;
import com.example.rentalproperty.entity.enums.TypeProperty;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class Generator {

    public static Tenant getUpdTenant() {
        Tenant tenant = new Tenant();
        tenant.setPreferenceDistrict("new PreferenceDistrict");
        tenant.setPreferenceNumRoom(5);
        tenant.setPreferenceMaxRent(new BigDecimal(5000));
        tenant.setPetFriendly(true);
        tenant.setParkingRequired(false);
        tenant.setPreferenceProperty(TypeProperty.OFFICE);
        return tenant;
    }

    public static Landlord getUpdLandlord() {
        Landlord landlord = new Landlord();
        landlord.setNumProperty(10);
        landlord.setNumFree(3);
        landlord.setRentedOut(7);
        return landlord;
    }

    public static Contract getUpdContract() {
        Contract contract = new Contract();
        contract.setStartDate(LocalDate.of(2024, 12, 15));
        contract.setEndDate(LocalDate.of(2040, 12, 15));
        return contract;
    }

    public static User getUpdUser(){
        User user = new User();
        user.setFirstName("Dima");
        user.setLastName("Bondarenko");

        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("DimaBon");
        userInfo.setEmail("dimabon@gmail.com");

        user.setUserInfo(userInfo);
        return user;
    }

}
