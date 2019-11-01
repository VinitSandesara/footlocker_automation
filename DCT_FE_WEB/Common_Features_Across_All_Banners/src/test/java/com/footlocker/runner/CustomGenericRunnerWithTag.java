package com.footlocker.runner;

import com.footlocker.customrunner.CustomAbstractTestNGCucumberTestsWithTag;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = {"src/test/resources"},
        glue = {"com.footlocker.steps"},
        dryRun = false,
        monochrome = true,
        plugin = {"pretty", "json:target/CucumberHtmlReport.json"}
)
public class CustomGenericRunnerWithTag extends CustomAbstractTestNGCucumberTestsWithTag {

}