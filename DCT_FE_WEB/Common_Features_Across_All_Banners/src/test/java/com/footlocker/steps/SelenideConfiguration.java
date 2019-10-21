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

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Boolean.parseBoolean;

public class SelenideConfiguration {

    private final String REPORTS_FOLDER = "target";
    public static WebDriver driver;

    public void getBrowser() {

        /* To Disable location popup */
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2);

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



        /* Option : 2 */
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("chrome.switches", "--disable-extensions");
        options.setExperimentalOption("prefs", prefs);

        options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

        driver = new ChromeDriver(options);
        Configuration.timeout = 20000;
        Configuration.baseUrl = "https://www.staging2.origin.eastbay.com/";
        driver.get(Configuration.baseUrl);
        WebDriverRunner.setWebDriver(driver);
        System.out.println("");

    }

    public void closeSession() {
        WebDriverRunner.closeWebDriver();
    }

}