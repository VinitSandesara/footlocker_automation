package com.footlocker.steps;


import Jenkins.JenkinsParamsVariable;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.After;
import io.cucumber.java.Before;


public class Hooks {

    private SelenideConfiguration selenideConfiguration;

    public Hooks(SelenideConfiguration selenideConfiguration) {
        this.selenideConfiguration = selenideConfiguration;
    }

    @Before
    public void BeforeScenario() {
        selenideConfiguration.getBrowser(JenkinsParamsVariable.TagName);

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