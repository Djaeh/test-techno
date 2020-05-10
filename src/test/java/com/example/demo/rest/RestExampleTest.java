package com.example.demo.rest;

import com.example.demo.DemoApplication;
import com.jayway.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.jayway.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DemoApplication.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class RestExampleTest {
    @LocalServerPort
    int port;

    @Test
    public void getDataTest() {
        get("/api/tdd/responseData").then().assertThat().body("data", equalTo("responseData"));
    }
    @Before
    public void setBaseUri () {
        RestAssured.port = port;
        RestAssured.baseURI = "http://localhost"; // replace as appropriate
    }
}
