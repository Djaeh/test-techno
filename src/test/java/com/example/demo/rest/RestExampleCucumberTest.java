package com.example.demo.rest;

import com.example.demo.DemoApplication;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@RunWith(Cucumber.class)
@ContextConfiguration(classes = DemoApplication.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@CucumberOptions(features = "src/test/resources/rest/restExample.feature",
        plugin = {"pretty", "html:target/cucumber"},
        glue = {"com.example.demo"})
public class RestExampleCucumberTest {
}
