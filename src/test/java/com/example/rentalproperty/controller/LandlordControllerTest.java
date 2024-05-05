package com.example.rentalproperty.controller;

import com.example.rentalproperty.controller.util.Generator;
import com.example.rentalproperty.dto.LandlordCreateDto;
import com.example.rentalproperty.entity.Landlord;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Sql("/db/drop.sql")
@Sql("/db/schemaTest.sql")
@Sql("/db/dataTest.sql")
public class LandlordControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void createLandlordPositiveTest() throws Exception {
        LandlordCreateDto landlordCreateDto = new LandlordCreateDto(10, 4, 6);

        String json = objectMapper.writeValueAsString(landlordCreateDto);

        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.post("/landlord/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andReturn();

        Assertions.assertEquals(200, result.getResponse().getStatus());
    }

    @Test
    void changeLandlordPositiveTest() throws Exception {
        Landlord landlord = Generator.getUpdLandlord();
        String json = objectMapper.writeValueAsString(landlord);

        MvcResult landlordResult = mockMvc
                .perform(MockMvcRequestBuilders.put("/landlord/update/e8240961-836b-43cc-948c-4fb4d2cbcb18")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andReturn();

        Assertions.assertEquals(200, landlordResult.getResponse().getStatus());
    }

    @Test
    void getLandlordByIdPositiveTest() throws Exception {
        MockHttpServletResponse landlordGetResult = mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/landlord/get/e8240961-836b-43cc-948c-4fb4d2cbcb18"))
                .andExpect(status().isOk()).andReturn().getResponse();

        Assertions.assertEquals(landlordGetResult.getStatus(), HttpStatus.OK.value());

    }

    @Test
    void deleteLandlordByPositiveTest() throws Exception {
        MockHttpServletResponse landlordDeleteResult = mockMvc
                .perform(MockMvcRequestBuilders
                        .delete("/landlord/delete/e8240961-836b-43cc-948c-4fb4d2cbcb18"))
                .andExpect(status().isOk()).andReturn().getResponse();

        Assertions.assertEquals(landlordDeleteResult.getStatus(), HttpStatus.OK.value());
    }
}
