package com.example.rentalproperty.controller;

import com.example.rentalproperty.controller.util.Generator;
import com.example.rentalproperty.dto.UserCreateDto;
import com.example.rentalproperty.entity.User;
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

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser(username = "john_doe", password = "password123", roles = "ADMINISTRATOR")
@Sql("/db/drop.sql")
@Sql("/db/schemaTest.sql")
@Sql("/db/dataTest.sql")
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void createUserPositiveTest() throws Exception{
        UserCreateDto userCreateDto = new UserCreateDto("Andrey", "Bondarenko", "anbond@gmail.com", "password", "AndreyBon");

        String json = objectMapper.writeValueAsString(userCreateDto);

        mockMvc.perform(MockMvcRequestBuilders.post("/user/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk());
    }

    @Test
    void changeUserPositiveTest() throws Exception {
        User user = Generator.getUpdUser();
        String json = objectMapper.writeValueAsString(user);

        MvcResult userResult = mockMvc
                .perform(MockMvcRequestBuilders.put("/user/update/654cc27a-1082-4e64-86b9-93003c5d2ad2")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andReturn();

        Assertions.assertEquals(200, userResult.getResponse().getStatus());
    }

    @Test
    void getUserByIdPositiveTest() throws Exception {
        MockHttpServletResponse userGetResult = mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/user/get/590f1736-3040-4827-9847-e4160678671b"))
                .andExpect(status().isOk()).andReturn().getResponse();

        Assertions.assertEquals(userGetResult.getStatus(), HttpStatus.OK.value());
    }

    @Test
    void deleteUserPositiveTest() throws Exception {
        MockHttpServletResponse userDeleteResult = mockMvc
                .perform(MockMvcRequestBuilders
                        .delete("/user/delete/654cc27a-1082-4e64-86b9-93003c5d2ad2"))
                .andExpect(status().isOk()).andReturn().getResponse();

        Assertions.assertEquals(userDeleteResult.getStatus(), HttpStatus.OK.value());
    }
}
