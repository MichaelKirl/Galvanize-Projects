package com.example.springformdata;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class formControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void formDataPost() throws Exception {
        MockHttpServletRequestBuilder request = post("/math/area")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("type", "circle")
                .param("radius", "4");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Area of a circle with a radius of 4 is 50.26548"));
    }

    @Test
    public void formDataRectanglePost() throws Exception {
        MockHttpServletRequestBuilder request = post("/math/area")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("type", "rectangle")
                .param("width", "4")
                .param("height", "4");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Area of a 4x4 rectangle is 16"));
    }

    @Test
    public void formDataIhvalidPost() throws Exception {
        MockHttpServletRequestBuilder request = post("/math/area")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("type", "wOw")
                .param("width", "4")
                .param("height", "4");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Invalid"));
    }
}
