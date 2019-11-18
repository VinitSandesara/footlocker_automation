package com.footlocker.runner;

import ExtentReport.ExtentManager;
import ExtentReport.ExtentTestManager;
import com.footlocker.steps.Hooks;
import courgette.api.CourgetteAfterAll;
import courgette.api.CourgetteBeforeAll;

import courgette.api.CourgetteOptions;
import courgette.api.CourgetteRunLevel;
import courgette.api.junit.Courgette;
import courgette.api.CucumberOptions;

import org.junit.runner.RunWith;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import courgette.api.testng.TestNGCourgette;

/* Using Junit

@RunWith(Courgette.class)
@CourgetteOptions(
        threads = 10,
        runLevel = CourgetteRunLevel.SCENARIO,
        rerunFailedScenarios = false,
        showTestOutput = true,
        reportTargetDir = "build",
        cucumberOptions = @CucumberOptions(
                features = "src/test/resources/features",
                glue = "com.footlocker.steps",
                tags = {"@Register_Multi_User", "not @excluded"},
                plugin = {
                        "pretty",
                        "json:build/cucumber-report/cucumber.json",
                        "html:build/cucumber-report/cucumber.html",
                        "junit:build/cucumber-report/cucumber.xml"},
                strict = true
        ))
public class CourgetteRunner {

} */

/* Using TestNg */

@Test
@CourgetteOptions(
        threads = 10,
        runLevel = CourgetteRunLevel.SCENARIO,
        rerunFailedScenarios = false,
        showTestOutput = true,
        reportTargetDir = "target/CourgetteHtmlReport",
        cucumberOptions = @CucumberOptions(
                features = "src/test/resources/features",
                glue = "com.footlocker.steps",
              //  tags = {"@Debug_New_Single_User"},
                plugin = {"pretty",
                        "json:target/CourgetteHtmlReport/cucumber-report/cucumber.json",
                        "html:target/CourgetteHtmlReport/cucumber-report/cucumber.html"},
                strict = true
        ))


public class CourgetteRunner extends TestNGCourgette {

  /*  @AfterSuite
    public void teadown() {
        ExtentTestManager.endTest();
        ExtentManager.getInstance().flush();
    } */

}
