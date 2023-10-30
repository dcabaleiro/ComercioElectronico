package com.minsait.comercioelectronico.controller;

import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@SpringBootTest
@AutoConfigureMockMvc
class PricesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void searchPrice_Test1() throws Exception {
        JSONObject test = new JSONObject();
        test.put("date", "2020-06-14 10:00:00");
        test.put("productId", 35455);
        test.put("brandId", 1);

        MvcResult result = this.mockMvc.perform(get(
                "/price?"
                        + "fecha=" + test.get("date")
                        + "&productId=" +test.get("productId")
                        + "&brandId=" + test.get("brandId")
                ))
                .andReturn();
        JSONObject body = new JSONObject(result.getResponse().getContentAsString());
        Assertions.assertEquals(body.getDouble("price"), 35.5);
        Assertions.assertEquals(body.getInt("brandId"), 1);
        Assertions.assertEquals(body.getInt("priceList"), 1);
        Assertions.assertEquals(result.getResponse().getStatus(), 200);
    }

    @Test
    void searchPrice_Test2() throws Exception {
        JSONObject test = new JSONObject();
        test.put("date", "2020-06-14 16:00:00");
        test.put("productId", 35455);
        test.put("brandId", 1);

        MvcResult result = this.mockMvc.perform(get(
                        "/price?"
                                + "fecha=" + test.get("date")
                                + "&productId=" +test.get("productId")
                                + "&brandId=" + test.get("brandId")
                ))
                .andReturn();
        JSONObject body = new JSONObject(result.getResponse().getContentAsString());
        Assertions.assertEquals(body.getDouble("price"), 25.45);
        Assertions.assertEquals(body.getInt("brandId"), 1);
        Assertions.assertEquals(body.getInt("priceList"), 2);
        Assertions.assertEquals(result.getResponse().getStatus(), 200);
    }

    @Test
    void searchPrice_Test3() throws Exception {
        JSONObject test = new JSONObject();
        test.put("date", "2020-06-14 21:00:00");
        test.put("productId", 35455);
        test.put("brandId", 1);

        MvcResult result = this.mockMvc.perform(get(
                        "/price?"
                                + "fecha=" + test.get("date")
                                + "&productId=" +test.get("productId")
                                + "&brandId=" + test.get("brandId")
                ))
                .andReturn();
        JSONObject body = new JSONObject(result.getResponse().getContentAsString());
        Assertions.assertEquals(body.getDouble("price"), 35.5);
        Assertions.assertEquals(body.getInt("brandId"), 1);
        Assertions.assertEquals(body.getInt("priceList"), 1);
        Assertions.assertEquals(result.getResponse().getStatus(), 200);
    }

    @Test
    void searchPrice_Test4() throws Exception {
        JSONObject test = new JSONObject();
        test.put("date", "2020-06-15 10:00:00");
        test.put("productId", 35455);
        test.put("brandId", 1);

        MvcResult result = this.mockMvc.perform(get(
                        "/price?"
                                + "fecha=" + test.get("date")
                                + "&productId=" +test.get("productId")
                                + "&brandId=" + test.get("brandId")
                ))
                .andReturn();
        JSONObject body = new JSONObject(result.getResponse().getContentAsString());
        Assertions.assertEquals(body.getDouble("price"), 30.5);
        Assertions.assertEquals(body.getInt("brandId"), 1);
        Assertions.assertEquals(body.getInt("priceList"), 3);
        Assertions.assertEquals(result.getResponse().getStatus(), 200);
    }

    @Test
    void searchPrice_Test5() throws Exception {
        JSONObject test = new JSONObject();
        test.put("date", "2020-06-16 21:00:00");
        test.put("productId", 35455);
        test.put("brandId", 1);

        MvcResult result = this.mockMvc.perform(get(
                        "/price?"
                                + "fecha=" + test.get("date")
                                + "&productId=" +test.get("productId")
                                + "&brandId=" + test.get("brandId")
                ))
                .andReturn();        JSONObject body = new JSONObject(result.getResponse().getContentAsString());
        Assertions.assertEquals(body.getDouble("price"), 38.95);
        Assertions.assertEquals(body.getInt("brandId"), 1);
        Assertions.assertEquals(body.getInt("priceList"), 4);
        Assertions.assertEquals(result.getResponse().getStatus(), 200);
    }

}