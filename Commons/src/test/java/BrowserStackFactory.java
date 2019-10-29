import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class BrowserStackFactory implements WebDriverProvider {

    public static final String USERNAME = "feqa7";
    public static final String AUTOMATE_KEY = "tpB1N7Jtzs4ecuWy5JqB";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    @Override
    public WebDriver createDriver(DesiredCapabilities capabilities) {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "70.0");
        caps.setCapability("os", "OS X");
        caps.setCapability("os_version", "Mojave");
        caps.setCapability("resolution", "1024x768");
        caps.setCapability("name", "Bstack-[Java] Sample Test");

       // String URL = "http://<username>:<automate-key>@hub.browserstack.com/wd/hub";


        try {
            return new RemoteWebDriver(new URL(URL), caps);
        } catch (Exception e) {
            return null;
        }


    }


}