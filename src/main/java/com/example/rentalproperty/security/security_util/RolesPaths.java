package com.example.rentalproperty.security.security_util;

public class RolesPaths {
    public static final String LANDLORD = "LANDLORD";
    public static final String TENANT = "TENANT";
    public static final String USER = "USER";
    public static final String ADMIN = "ADMIN";

    public static final String[] LANDLORD_LIST = {
            "/v2/api-docs",
            "/v3/api-docs/**",
            "/swagger-resources/**",
            "/swagger-ui/**",
            "/configuration/**",
            "/h2-console/**",
            "/landlord/**",
            "/tenant/**",
            "/application/**"
    };

    public static final String[] TENANT_LIST = {
            "/v2/api-docs",
            "/v3/api-docs/**",
            "/swagger-resources/**",
            "/swagger-ui/**",
            "/configuration/**",
            "/h2-console/**",
            "/contract/create"
    };

    public static final String[] USER_LIST = {
            "/v2/api-docs",
            "/v3/api-docs/**",
            "/swagger-resources/**",
            "/swagger-ui/**",
            "/configuration/**",
            "/h2-console/**",
            "/contract/get/{id}",
            "/user/get/{id}",
            "/user/delete/{id}",
            "/user/update/{id}",
            "/users/create"
    };

    public static final String[] ADMIN_LIST = {
            "/v2/api-docs",
            "/v3/api-docs/**",
            "/swagger-resources/**",
            "/swagger-ui/**",
            "/configuration/**",
            "/h2-console/**",
            "/contract/**",
            "/landlord/**",
            "/tenant/**",
            "/users/get/{id}"
    };
}

