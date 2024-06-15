package com.example.rentalproperty.security.security_util;

public class RolesPaths {
    public static final String LANDLORD = "LANDLORD";
    public static final String TENANT = "TENANT";
    public static final String ADMIN = "ADMIN";

    public static final String[] SWAGGER_LIST = {
            "/v2/api-docs",
            "/v3/api-docs/**",
            "/swagger-resources/**",
            "/swagger-resources",
            "/swagger-ui/",
            "/swagger-ui.html",
            "/swagger-ui/**",
            "/webjars/**",
            "/configuration/**",
            "/configuration/ui",
            "/configuration/security",
            "/public",
            "/favicon.ico",
            "/h2-console/**"
    };

    public static final String[] AUTH_LIST =
            {
                    "/tenant/**",
                    "/contract/**",
                    "/landlord/**",
                    "/user/**"
            };
}

