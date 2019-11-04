package com.footlocker.runner;


import com.footlocker.customrunner.CustomAbstractTestNGCucumberTestsWithTag;
import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import org.junit.runner.RunWith;


@CucumberOptions(


        features = {"src/test/resources"},
        glue = {"com.footlocker.steps"},
      //  tags = "@Debug_PostSSO_FS",
        dryRun = false,
        monochrome = true,
        plugin = {"pretty", "json:target/CucumberHtmlReport.json"}


)

//public class TestRunner extends AbstractTestNGCucumberTests {
public class TestRunner extends CustomAbstractTestNGCucumberTestsWithTag {
}
