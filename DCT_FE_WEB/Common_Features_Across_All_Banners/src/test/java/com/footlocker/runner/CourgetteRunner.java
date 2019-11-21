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

import org.apache.commons.io.FileUtils;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import courgette.api.testng.TestNGCourgette;

import java.io.File;
import java.io.IOException;



/* Using Junit

@RunWith(Courgette.class)
@CourgetteOptions(
      //  threads = 10,
      //  runLevel = CourgetteRunLevel.SCENARIO,
        rerunFailedScenarios = false,
        showTestOutput = true,
        reportTargetDir = "target/CourgetteHtmlReport",
        cucumberOptions = @CucumberOptions(
                features = "src/test/resources/features",
                glue = "com.footlocker.steps",
             //   tags = {"@Debug_New_Single_User", "not @excluded"},
                plugin = {
                        "pretty",
                        "json:target/CourgetteHtmlReport/cucumber-report/cucumber.json",
                        "html:target/CourgetteHtmlReport/cucumber-report/cucumber.html",
                        "junit:target/CourgetteHtmlReport/cucumber-report/cucumber.xml"},
                strict = true
        ))
public class CourgetteRunner {

}  */

/* Using TestNg */

@Test
@CourgetteOptions(
       // threads = 10,
       // runLevel = CourgetteRunLevel.FEATURE,
        rerunFailedScenarios = false,
        showTestOutput = false,
        reportTargetDir = "target/CourgetteHtmlReport",
        cucumberOptions = @CucumberOptions(
                features = "src/test/resources/features",
                glue = "com.footlocker.steps",
             //   tags = {"@Debug_New_Single_User"},
                plugin = {"pretty",
                        "json:target/CourgetteHtmlReport/cucumber-report/cucumber.json",
                        "html:target/CourgetteHtmlReport/cucumber-report/cucumber.html"},
                strict = true
        ))


public class CourgetteRunner extends TestNGCourgette {

        @AfterClass
        public void tearDownFolder() throws IOException {

                /* Removing build folder where screenshot is getting saved,
                don't need it once it converted to base64
                 */
                String path = System.getProperty("user.dir");
                File index = new File(path + "/build");
                FileUtils.deleteDirectory(new File(String.valueOf(index)));



        }

}
