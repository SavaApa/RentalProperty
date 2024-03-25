package com.example.rentalproperty.entity;

import java.util.UUID;

public class User {
    private UUID id;
    private String first_name;
    private String last_name;
    private UserInfo userInfo;
    private Tenant tenant;
    private Landlord landlord;
}
