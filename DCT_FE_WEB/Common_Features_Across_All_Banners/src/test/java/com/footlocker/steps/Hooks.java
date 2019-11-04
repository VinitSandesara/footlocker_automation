package com.footlocker.steps;


import GoogleApiUtil.GoogleSheetData;
import Jenkins.JenkinsParamsVariable;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.util.Collection;


public class Hooks {

    private SelenideConfiguration selenideConfiguration;
    public static String key;

    public Hooks(SelenideConfiguration selenideConfiguration) {
        this.selenideConfiguration = selenideConfiguration;
    }

    @Before
    public void BeforeScenario(Scenario scenario) {
        selenideConfiguration.getBrowser(JenkinsParamsVariable.TagName);

        key = scenario.getSourceTagNames().iterator().next();

        Configuration.baseUrl = GoogleSheetData.getCellValueBasedOnColumnName(
                    JenkinsParamsVariable.getSheetNameWithItsRowNumber.get(key).get(0),
                    Integer.parseInt(JenkinsParamsVariable.getSheetNameWithItsRowNumber.get(key).get(1)),
                    "Banner"
            );

            SelenideConfiguration.driver.get(Configuration.baseUrl);


       /* InputStream in =
                Hooks.class.getResourceAsStream("/extent-config.xml");

        String path = String.valueOf(new InputStreamReader(in));

        Reporter.loadXMLConfig(String.valueOf(new InputStreamReader(in))); */

    }

    @After
    public void AfterScenario() {
    /* Option: 1
      //  selenideConfiguration.closeSession(); */

        /* Option: 2 */
        WebDriverRunner.getWebDriver().quit();
    }
}