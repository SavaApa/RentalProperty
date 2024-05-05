package com.example.rentalproperty.controller;

import com.example.rentalproperty.controller.util.Generator;
import com.example.rentalproperty.dto.TenantCreateDto;
import com.example.rentalproperty.entity.Tenant;
import com.example.rentalproperty.entity.enums.TypeProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;

@SpringBootTest
@AutoConfigureMockMvc
@Sql("/db/drop.sql")
@Sql("/db/schemaTest.sql")
@Sql("/db/dataTest.sql")
public class TenantControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void createTenantPositiveTest() throws Exception {
        TenantCreateDto tenantCreateDto = new TenantCreateDto("Suborbital", 3,
                new BigDecimal(3000), TypeProperty.APARTMENT);

        String json = objectMapper.writeValueAsString(tenantCreateDto);

        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.post("/tenant/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andReturn();

        Assertions.assertEquals(200, result.getResponse().getStatus());
    }

    @Test
    void changeTenant() throws Exception {
        Tenant tenant = Generator.getUpdTenant();
        String json = objectMapper.writeValueAsString(tenant);

        MvcResult tenantResult = mockMvc
                .perform(MockMvcRequestBuilders.put("/tenant/update/193e4a81-38c8-4f18-bdf7-590205283979")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andReturn();

        Assertions.assertEquals(200, tenantResult.getResponse().getStatus());
    }
}
