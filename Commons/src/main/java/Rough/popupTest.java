package Rough;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$;

public class popupTest {

   /* public static WebDriver driver;

    public static void main(String[] args) {

        // Create object of HashMap Class
        Map<String, Object> prefs = new HashMap<String, Object>();

        // Set the notification setting it will override the default setting
        prefs.put("profile.default_content_setting_values.notifications", 2);

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        // options.addArguments("--incognito");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("chrome.switches", "--disable-extensions");
        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);
        Configuration.timeout = 10000;
        Configuration.baseUrl = "https://www.staging2.origin.footlocker.com/";
        driver.get(Configuration.baseUrl);
        WebDriverRunner.setWebDriver(driver);

         Selenide.refresh();

        $(By.id("input_search_query")).sendKeys("Nike");
        $(By.id("input_search_query")).sendKeys(Keys.ENTER);


        Actions action = new Actions(driver);
        action.sendKeys(Keys.ESCAPE).build().perform();

        // $(By.id("closeButtonWhite")).click();

        // ElementGuard.guard($(By.id("at-cv-lightbox-close")));

        WebDriverRunner.getWebDriver().quit();


    }*/


}
