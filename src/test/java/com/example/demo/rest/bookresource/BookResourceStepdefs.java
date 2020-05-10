package com.example.demo.rest.bookresource;

import com.example.demo.DemoApplication;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ValidatableResponse;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.test.context.ContextConfiguration;

import java.sql.SQLException;
import java.util.Map;

import static com.jayway.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;

@ContextConfiguration(classes = DemoApplication.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class BookResourceStepdefs {

    @LocalServerPort
    int port;

    Response response;
    private ValidatableResponse json;

    @Given("The test server is initialized")
    public void the_test_server_is_initialized() {
        RestAssured.port = this.port;
        RestAssured.baseURI = "http://localhost"; // replace as appropriate
    }

    @When("^user call (.+)$")
    public void userCallApiBookIsbn(String path) {
        response = get(path);
        System.out.println("response: " + response.prettyPrint());
    }

    @Then("server answer with")
    public void serverAnswerWith(Map<String, String> expectedJson) {
        for (Map.Entry<String, String> field : expectedJson.entrySet()) {
            if(StringUtils.isNumeric(field.getValue())){
                json.body(field.getKey(), equalTo(Integer.parseInt(field.getValue())));
            }
            else{
                json.body(field.getKey(), equalTo(field.getValue()));
            }
        }
    }

    @Then("^the request status code is (\\d+)$")
    public void theRequestStatusCodeIs(int statusCode) {
        json = response.then().statusCode(statusCode);
    }
}
