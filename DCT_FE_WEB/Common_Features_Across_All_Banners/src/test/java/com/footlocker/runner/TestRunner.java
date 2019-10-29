package com.footlocker.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        monochrome = true,
       	plugin = {"pretty","json:target/CucumberHtmlReport.json"},
        dryRun = false,
        strict = true,
        tags = "@Debug_PostSSO",
        features = "src/test/resources",
        glue = "com.footlocker.steps")

public class TestRunner {
}
