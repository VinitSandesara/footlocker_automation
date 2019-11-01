package com.footlocker.runner;

import com.footlocker.customrunner.CustomAbstractTestNGCucumberTests;


import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"src/test/resources"},
		glue = {"com.footlocker.steps"},
		dryRun = false,
		monochrome = true,
				plugin = {"pretty","json:target/CucumberHtmlReport.json"}
		)
public class CustomGenericRunner extends CustomAbstractTestNGCucumberTests {

}