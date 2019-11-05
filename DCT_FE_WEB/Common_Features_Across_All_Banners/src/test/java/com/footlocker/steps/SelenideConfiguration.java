package com.footlocker.steps;

import com.codeborne.selenide.*;
import com.codeborne.selenide.drivercommands.CreateDriverCommand;
import com.codeborne.selenide.drivercommands.WebDriverWrapper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Boolean.parseBoolean;

public class SelenideConfiguration {

    private final String REPORTS_FOLDER = "target";
    public static WebDriver driver;

    public static final String USERNAME = "feqa7";
    public static final String AUTOMATE_KEY = "tpB1N7Jtzs4ecuWy5JqB";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    public void getBrowser(String TestCaseName) {




    /* Options :1
        String browser = System.getProperty("selenide.browser", "chrome");
        boolean headless = parseBoolean(System.getProperty("selenide.headless", "false"));
        Configuration.browser = browser;
        Configuration.headless = headless;
        Configuration.startMaximized = false;
        Configuration.browserSize = "1600x1200";
        Configuration.timeout = 20000;
        Configuration.screenshots = true;
        Configuration.reportsFolder = REPORTS_FOLDER;
        Configuration.baseUrl = "https://www.staging2.origin.champssports.com/";
        Selenide.clearBrowserCookies();
        Selenide.open(Configuration.baseUrl); */



        /* Option : 2
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2);

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("chrome.switches", "--disable-extensions");
        options.setExperimentalOption("prefs", prefs);
        options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        options.setExperimentalOption("useAutomationExtension", false);
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));


        driver = new ChromeDriver(options);
        Configuration.timeout = 20000;
      //  Configuration.baseUrl = "https://www.staging2.origin.footlocker.com/";
      //  driver.get(Configuration.baseUrl);
        WebDriverRunner.setWebDriver(driver);
        System.out.println("");  */


        /* ============ Option 3 - BrowserStack ============ */

    /* MAC - CHROME */

        DesiredCapabilities caps = new DesiredCapabilities();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        caps.setCapability(ChromeOptions.CAPABILITY, options);

        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "70.0");
        caps.setCapability("os", "OS X");
        caps.setCapability("os_version", "Mojave");
        // caps.setCapability("resolution", "1024x768");
        caps.setCapability("browserstack.debug", "true");
        caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        caps.setCapability("build", "New_User_Register");
        caps.setCapability("name", TestCaseName + "_CHROME");


    /* MAC - FIREFOX

        caps.setCapability("os", "OS X");
        caps.setCapability("os_version", "Mojave");
        caps.setCapability("browser", "Firefox");
        caps.setCapability("browser_version", "70.0");
        caps.setCapability("browserstack.local", "false");
        caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
         caps.setCapability("browserstack.debug", "true");
        caps.setCapability("build", "New_User_Register");
        caps.setCapability("name", TestCaseName + "_FIREFOX"); */

    /* MAC - SAFARI

        caps.setCapability("os", "OS X");
        caps.setCapability("os_version", "Mojave");
        caps.setCapability("browser", "Safari");
        caps.setCapability("browser_version", "12.1");
        caps.setCapability("browserstack.local", "false");
        caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        caps.setCapability("browserstack.debug", "true");
        caps.setCapability("build", "New_User_Register");
        caps.setCapability("name", TestCaseName + "_SAFARI"); */


        /* WINDOWS - IE

        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("browser", "IE");
        caps.setCapability("browser_version", "11.0");
        caps.setCapability("browserstack.local", "false");
        caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        caps.setCapability("browserstack.debug", "true");
        caps.setCapability("build", "New_User_Register");
        caps.setCapability("name", TestCaseName + "_WINDOWS_IE"); */

        /* WINDOWS - FIREFOX

        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("browser", "Firefox");
        caps.setCapability("browser_version", "70.0");
        caps.setCapability("browserstack.local", "false");
        caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        caps.setCapability("browserstack.debug", "true");
        caps.setCapability("build", "New_User_Register");
        caps.setCapability("name", TestCaseName + "_WINDOWS_FIREFOX"); */


        try {
            driver = new RemoteWebDriver(new URL(URL), caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        Configuration.timeout = 20000;

        WebDriverRunner.setWebDriver(driver);


    }

    public void closeSession() {
        WebDriverRunner.closeWebDriver();
    }

}