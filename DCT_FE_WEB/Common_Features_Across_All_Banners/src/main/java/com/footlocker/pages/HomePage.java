package com.footlocker.pages;

import com.codeborne.selenide.Condition;
import com.footlocker.core.BasePage;
import org.openqa.selenium.By;

import static SeleniumUtil.LocatorRepository.getLocator;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class HomePage extends BasePage {
    private final By DESKTOP_BROWSER_LOGIN_LINK = getLocator("Desktop.Browser.Login.Link");
    private final By DESKTOP_BROWSER_VERIFY_SIGNIN_DIALOG_BOX = getLocator("Desktop.Browser.Verify.SignIn.Dialog");
    private final By CREATE_AN_ACCOUNT_LINK = getLocator("CreateAnAccount.Link");
    private final By DESKTOP_BROWSER_LOGOUT_LINK = getLocator("Desktop.Browser.Click.Logout.Link");
      private final By DESKTOP_BROWSER_LOGOUT_BUTTON = getLocator("Desktop.Browser.Click.Logout.Button");




    public HomePage DesktopBrowser_ClickOnLoginLink() {
        $(DESKTOP_BROWSER_LOGIN_LINK).click();
        System.out.println("");
        return page(HomePage.class);
    }

    public HomePage DesktopBrowser_VerifySignInDialogBox() {
        $(DESKTOP_BROWSER_VERIFY_SIGNIN_DIALOG_BOX).shouldHave(Condition.text("Sign In"));
        return page(HomePage.class);
    }

    public RedirectionPage ClickCreateAnAccountLinkFromSignInDialog() {
        $(CREATE_AN_ACCOUNT_LINK).click();
        return page(RedirectionPage.class);
    }

    public HomePage LogOut() {
        $(DESKTOP_BROWSER_LOGOUT_LINK).click();
        $(DESKTOP_BROWSER_LOGOUT_BUTTON).click();
        return page(HomePage.class);
    }


}
