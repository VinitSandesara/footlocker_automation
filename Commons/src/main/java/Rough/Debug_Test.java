package Rough;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static java.lang.Boolean.parseBoolean;

public class Debug_Test {


   /* public static void main(String[] args) throws InterruptedException {


        String range = "A2:H2";

        List<String> list = new ArrayList<String>(Arrays.asList(range.split(":")));


        String[] part = list.get(0).split("(?<=\\D)(?=\\d)");
        System.out.println(part[0]);
        System.out.println(part[1]);

        int t = Integer.parseInt(part[1]) - 1;


        String browser = System.getProperty("selenide.browser", "chrome");
        boolean headless = parseBoolean(System.getProperty("selenide.headless", "false"));

        Configuration.browser = browser;
        Configuration.headless = headless;
        Configuration.startMaximized = false;
        // Configuration.browserSize="1600x1200";
        Configuration.screenshots = true;
        //  Configuration.reportsFolder = REPORTS_FOLDER;
        Configuration.baseUrl = "https://www.footlocker.com/";
        Selenide.open(Configuration.baseUrl);

        $(By.id("accountActions")).click();
        $(By.xpath("//button[contains(text(),'Sign Out')]")).click();

        //Thread.sleep(5000);

        String PageTitle = WebDriverRunner.url();

        $(By.xpath("//button[contains(text(),'Sign In / VIP') or contains(text(),'Welcome, Sign In')]")).click();
        $(By.xpath("//a[contains(text(),'Create an Account')]")).click();
        String text = $(By.id("pageTitle")).getText();
        $(By.xpath("//span[contains(text(),'Skip VIP rewards at this time')]")).click();


        ElementsCollection listOfInputs = $(By.id("AccountCreate")).$$(By.xpath("//input[@type='text']"));

        // String text = $(By.xpath("//div[@aria-labelledby='signInModalHeading']")).getText();

        Thread.sleep(8000);


    }*/


}
