package com.footlocker.core;


import com.codeborne.selenide.WebDriverRunner;
import com.footlocker.pages.HomePage;

import static com.codeborne.selenide.Selenide.page;

public class BasePage {


    public static HomePage goToHomePage() {
        if (WebDriverRunner.url().equalsIgnoreCase("https://www.footlocker.com/")) {
            System.out.println("YOU ARE PASS");
        }
        return page(HomePage.class);

    }


}
