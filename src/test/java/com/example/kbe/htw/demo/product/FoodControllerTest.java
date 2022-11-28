package com.example.kbe.htw.demo.product;

import com.example.kbe.htw.demo.food.FoodRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
public class FoodControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private FoodRepository foodRepository;

    @Test
    public void testGetFoodsShouldRespondFoodObject() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/foods");
        MvcResult result = this.mockMvc.perform(request).andReturn();
        assert result.getResponse().getStatus() == 200;
    }
}
