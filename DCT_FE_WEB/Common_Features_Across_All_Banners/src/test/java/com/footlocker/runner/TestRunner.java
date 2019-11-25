package com.footlocker.runner;



import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(


        features = {"src/test/resources/features"},
        glue = {"com.footlocker.steps"},
         tags = "@Debug_New_Single_User",
        dryRun = false,
        monochrome = true,
        plugin = {"pretty", "json:target/CucumberHtmlReport.json",
                "html:target/cucumber.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:target/Extentreport.html"}


)

//public class TestRunner extends AbstractTestNGCucumberTests {
//public class TestRunner extends CustomAbstractTestNGCucumberTestsWithTag {
public class TestRunner {

     /*  @AfterSuite
        public static void tearDown() {
                ExtentTestManager.endTest();
                ExtentManager.getInstance().flush();
        }*/

  /*  @AfterClass
    public static void teardown() {
        Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
        Reporter.setSystemInfo("user", System.getProperty("user.name"));
        Reporter.setSystemInfo("os", "Mac OSX");
        Reporter.setTestRunnerOutput("Sample test runner output message");
    }*/


}
