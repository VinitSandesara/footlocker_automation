package com.footlocker.runner;

import com.footlocker.customrunner.CustomAbstractTestNGCucumberTestsWithTag;
import cucumber.api.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources"},
        glue = {"com.footlocker.steps"},
        dryRun = false,
        monochrome = true,
        plugin = {"pretty", "json:target/customgenericrunnerwithtag.json"}
)
public class CustomGenericRunnerWithTag extends CustomAbstractTestNGCucumberTestsWithTag {

}