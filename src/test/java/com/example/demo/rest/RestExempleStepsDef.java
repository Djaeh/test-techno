package com.example.demo.rest;

import com.example.demo.DemoApplication;
import com.jayway.restassured.RestAssured;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.util.Strings;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ContextConfiguration;

import java.io.IOException;

import static com.jayway.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;

@ContextConfiguration(classes = DemoApplication.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class RestExempleStepsDef {

    private String data;
    private String path;

    @LocalServerPort
    int port;

    @Given("^(\\w+) as input data$")
    public void setData(String data) {
        this.data = data;
    }

    @When("^I call the service (.+)$")
    public void webServiceCall(String path) throws IOException {
        this.path = Strings.concat(path, data);
    }

    @Then("^The server answer contain (\\w+)$")
    public void checkData(String expectedBody) {
        get(this.path).then().assertThat().body("data", equalTo("responseData"));
    }

    @Given("^the test server is initialized$")
    public void theTestServerIsInitialized() {
        RestAssured.port = this.port;
        RestAssured.baseURI = "http://localhost"; // replace as appropriate
    }
}
