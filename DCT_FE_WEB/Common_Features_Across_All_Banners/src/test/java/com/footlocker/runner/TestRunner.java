package com.footlocker.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import org.junit.runner.RunWith;


@CucumberOptions(


        features = {"src/test/resources"},
        glue = {"com.footlocker.steps"},
        tags = "@Register_PostSSO_For_FL_KFL_FA_CS_Single_User",
        dryRun = false,
        monochrome = true,
        plugin = {"pretty", "json:target/CucumberHtmlReport.json"}


)

public class TestRunner extends AbstractTestNGCucumberTests {
}
