package com.example.rentalproperty.security.security_util;

public class RolesPaths {
    public static final String LANDLORD = "LANDLORD";
    public static final String TENANT = "TENANT";
    public static final String ADMIN = "ADMINISTRATOR";


    public static final String[] LANDLORD_LIST = {

            "/swagger-ui/**",
            "/configuration/**",
            "/h2-console/**",
            "/landlord/**",
            "/contract/**"

    };

    public static final String[] TENANT_LIST = {

            "/configuration/**",
            "/h2-console/**",
            "/tenant/**",
            "/contract/**"
    };

    public static final String[] ADMIN_LIST =

            {
                    "swagger-ui/**",
                    "/tenant/**",
                    "/contract/**",
                    "/landlord/**",
                    "/user/**"
            };
}

