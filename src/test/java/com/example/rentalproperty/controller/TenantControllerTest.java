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
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser(username = "Jane231", password = "password456", roles = "TENANT")
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

        MockHttpServletResponse result = mockMvc
                .perform(MockMvcRequestBuilders.post("/tenant/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                        .andExpect(status().isOk()).andReturn().getResponse();

        assertEquals(result.getStatus(), HttpStatus.OK.value());

    }

    @Test
    void changeTenantPositiveTest() throws Exception {
        Tenant tenant = Generator.getUpdTenant();
        String json = objectMapper.writeValueAsString(tenant);

        MvcResult tenantResult = mockMvc
                .perform(MockMvcRequestBuilders.put("/tenant/update/193e4a81-38c8-4f18-bdf7-590205283979")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andReturn();

        Assertions.assertEquals(200, tenantResult.getResponse().getStatus());
    }

    @Test
    void getTenantByIdPositiveTest() throws Exception {
        MockHttpServletResponse tenantGetResult = mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/tenant/get/193e4a81-38c8-4f18-bdf7-590205283979"))
                .andExpect(status().isOk()).andReturn().getResponse();

        Assertions.assertEquals(tenantGetResult.getStatus(), HttpStatus.OK.value());
    }

    @Test
    void deleteTenantPositiveTest() throws Exception {
        MockHttpServletResponse tenantDeleteResult = mockMvc
                .perform(MockMvcRequestBuilders
                        .delete("/tenant/delete/193e4a81-38c8-4f18-bdf7-590205283979"))
                .andExpect(status().isOk()).andReturn().getResponse();

        Assertions.assertEquals(tenantDeleteResult.getStatus(), HttpStatus.OK.value());
    }
}
