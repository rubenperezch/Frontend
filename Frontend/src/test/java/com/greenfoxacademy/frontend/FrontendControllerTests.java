package com.greenfoxacademy.frontend;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class FrontendControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void GETresponseDoubling() throws Exception {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("input","15");

        mockMvc.perform(get("/doubling")
                        .content(String.valueOf(jsonObject))
                        .contentType("application/json"))
                .andExpect(status().isOk())
                //.andExpect(jsonPath("$.received",is(15)))
                //.andExpect(jsonPath("$.result",is(30))
                ;
    }

    @Test
    public void GETresponseDoublingError() throws Exception{

        JSONObject jsonObject = new JSONObject();

        mockMvc.perform(get("/doubling")
                        .content(String.valueOf(jsonObject))
                        .contentType("application/json"))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.error",is("Please provide an input!"))
                );
    }


}

