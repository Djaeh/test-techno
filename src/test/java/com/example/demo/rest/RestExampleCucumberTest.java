package com.example.demo.rest;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/rest/restExample.feature",
        plugin = {"pretty", "html:target/cucumber"},
        glue = {"com.example.demo"})
public class RestExampleCucumberTest {
}
