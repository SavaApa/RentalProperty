package com.example.rentalproperty.controller;

import com.example.rentalproperty.controller.util.Generator;
import com.example.rentalproperty.dto.ContractCreateDto;
import com.example.rentalproperty.entity.Contract;
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

import java.time.LocalDate;
import java.util.UUID;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser(username = "john_doe", password = "password123", roles = "LANDLORD")
@Sql("/db/drop.sql")
@Sql("/db/schemaTest.sql")
@Sql("/db/dataTest.sql")
public class ContractControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void createContractPositiveTest() throws Exception {
        LocalDate startDate = LocalDate.of(2024, 12, 15);
        LocalDate endDate = LocalDate.of(2028, 3, 15);
        ContractCreateDto contractCreateDto = new ContractCreateDto(startDate, endDate, "ACCEPTED",
                "OFFICE", "OFFICE", UUID.fromString("e8240961-836b-43cc-948c-4fb4d2cbcb18"));

        String json = objectMapper.writeValueAsString(contractCreateDto);

        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.post("/contract/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andReturn();

        Assertions.assertEquals(200, result.getResponse().getStatus());
    }

    @Test
    void changeContractPositiveTest() throws Exception {
        Contract contract = Generator.getUpdContract();
        String json = objectMapper.writeValueAsString(contract);

        MvcResult contractResult = mockMvc
                .perform(MockMvcRequestBuilders.put("/contract/update/7e4ab44b-2ef3-46ef-ac38-c00fa7ad36cd")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andReturn();

        Assertions.assertEquals(200, contractResult.getResponse().getStatus());
    }

    @Test
    void getContractByIdPositiveTest() throws Exception {
        MockHttpServletResponse contractGetResult = mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/contract/get/7e4ab44b-2ef3-46ef-ac38-c00fa7ad36cd"))
                .andExpect(status().isOk()).andReturn().getResponse();

        Assertions.assertEquals(contractGetResult.getStatus(), HttpStatus.OK.value());
    }

    @Test
    void deleteContractPositiveTest() throws Exception {
        MockHttpServletResponse contractDeleteResult = mockMvc
                .perform(MockMvcRequestBuilders
                        .delete("/contract/delete/7e4ab44b-2ef3-46ef-ac38-c00fa7ad36cd"))
                .andExpect(status().isOk()).andReturn().getResponse();

        Assertions.assertEquals(contractDeleteResult.getStatus(), HttpStatus.OK.value());
    }
}
