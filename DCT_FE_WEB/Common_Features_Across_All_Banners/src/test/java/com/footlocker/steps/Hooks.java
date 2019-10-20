package com.footlocker.steps;

import GoogleApiUtil.GoogleSheetAPI_GetCall;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.vimalselvam.cucumber.listener.Reporter;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Hooks {

    private SelenideConfiguration selenideConfiguration;

    public Hooks(SelenideConfiguration selenideConfiguration) {
        this.selenideConfiguration = selenideConfiguration;
    }

    @Before
    public void BeforeScenario() {
        selenideConfiguration.getBrowser();

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