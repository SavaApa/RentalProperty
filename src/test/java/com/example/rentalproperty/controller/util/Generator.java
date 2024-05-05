package com.example.rentalproperty.controller.util;

import com.example.rentalproperty.entity.Tenant;
import com.example.rentalproperty.entity.enums.TypeProperty;

import java.math.BigDecimal;
import java.util.UUID;

public class Generator {

    public static Tenant getUpdTenant() {
        Tenant tenant = new Tenant();
        tenant.setId(UUID.fromString("193e4a81-38c8-4f18-bdf7-590205283979"));
        tenant.setPreferenceDistrict("new PreferenceDistrict");
        tenant.setPreferenceNumRoom(5);
        tenant.setPreferenceMaxRent(new BigDecimal(5000));
        tenant.setPetFriendly(true);
        tenant.setParkingRequired(false);
        tenant.setPreferenceProperty(TypeProperty.OFFICE);
        return tenant;
    }
}
