package com.footlocker;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        monochrome = true,
        plugin = {"pretty", "html:target/cucumber"},
        dryRun = false,
        strict = true,
        tags = "@Register_PostSSO_FS_EB_Single_User",
        features = "src/test/resources",
        glue = "com.footlocker.steps")

public class TestRunner {
}
