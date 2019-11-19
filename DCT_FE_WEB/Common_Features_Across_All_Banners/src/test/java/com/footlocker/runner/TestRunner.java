package com.footlocker.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(


        features = {"src/test/resources/features"},
        glue = {"com.footlocker.steps"},
         tags = "@Register_PostSSO_FL_KFL_FA_CS_Multi_User",
        dryRun = false,
        monochrome = true,
        plugin = {"pretty", "json:target/CucumberHtmlReport.json"}


)

//public class TestRunner extends AbstractTestNGCucumberTests {
//public class TestRunner extends CustomAbstractTestNGCucumberTestsWithTag {
public class TestRunner {

     /*  @AfterSuite
        public static void tearDown() {
                ExtentTestManager.endTest();
                ExtentManager.getInstance().flush();
        }*/


}
