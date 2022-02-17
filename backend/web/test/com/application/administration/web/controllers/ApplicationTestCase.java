package com.application.administration.web.controllers;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public abstract class ApplicationTestCase {

    public static final String PREFIX = "/api/v1";

    @Autowired
    protected MockMvc mockMvc;

    protected void assertResponse(String endpoint, Integer expectedStatusCode) throws Exception {
        mockMvc
                .perform(get(endpoint))
                .andExpect(status().is(expectedStatusCode));
    }

    protected void assertResponse(
            String endpoint,
            Integer expectedStatusCode,
            String expectedResponse
    ) throws Exception {
        ResultMatcher response = expectedResponse.isEmpty()
                ? content().string("")
                : content().json(expectedResponse);

        mockMvc
                .perform(get(endpoint))
                .andExpect(status().is(expectedStatusCode))
                .andExpect(response);
    }

    protected void assertRequestWithBody(
            String method, String endpoint, String body, Integer expectedStatusCode
    ) throws Exception {
        mockMvc
                .perform(
                        request(HttpMethod.valueOf(method), endpoint)
                                .accept(APPLICATION_JSON)
                                .content(body)
                                .contentType(APPLICATION_JSON)
                )
                .andExpect(status().is(expectedStatusCode));
    }
}
