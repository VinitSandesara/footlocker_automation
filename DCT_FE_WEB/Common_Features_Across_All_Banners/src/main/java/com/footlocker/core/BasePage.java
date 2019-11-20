package com.footlocker.core;


import GoogleApiUtil.GoogleSheetData;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.footlocker.pages.HomePage;
import io.cucumber.java.Scenario;


import static com.codeborne.selenide.Selenide.page;

public class BasePage  {

   public static Scenario getScenario;


    public static HomePage goToHomePage(Scenario scenario, String UserEmailID) {

        getScenario = scenario;
        String userEmailIdLog = "<b> <font size=\"5\" color=\"red\">User Email ID :- </font>  <font size=\"5\" color=\"blue\"> "+UserEmailID+" </font></b>";
        getScenario.embed(userEmailIdLog.getBytes(), "text/html");
        getScenario.embed("<font size=\"5\" color=\"green\">Navigated to home page</font></b>".getBytes(),"text/html");

        Selenide.refresh();
        if (WebDriverRunner.url().equalsIgnoreCase("https://www.footlocker.com/")) {
            System.out.println("YOU ARE PASS");
        }

        return page(HomePage.class);

    }


}
