package com.example.demo.rest.bookresource;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/rest/bookresource/bookResource.feature",
        plugin = {"pretty", "html:target/cucumber"},
        glue = {"com.example.demo.rest.bookresource"})
public class BookResourceTest {
}
