package com.footlocker.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.footlocker.core.BasePage;
import org.openqa.selenium.By;

import static SeleniumUtil.LocatorRepository.getLocator;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class RedirectionPage extends BasePage {

    private final By VERIFY_CREATE_AN_ACCOUNT_PAGE_REDIRECTION = getLocator("Verify.CreateAnAccount.Page.Redirection");
    private final By VERIFY_ALMOST_DONE_PAGE_REDIRECTION = getLocator("Verify.AlmostDone.Page.Redirection");
    private final By VERIFY_SUCCESS_PAGE_REDIRECTION = getLocator("Verify.Success.Page.Redirection");
    private final By VERIFY_ACTIVATE_YOUR_ACCOUNT_PAGE_REDIRECTION = getLocator("Verify.Activate.Your.Account.Page.Redirection");

    public CreateAccountPage VerifyCreateAnAccountPage(String PageName) {
        Selenide.refresh();
        $(VERIFY_CREATE_AN_ACCOUNT_PAGE_REDIRECTION).shouldHave(Condition.text(PageName));
        return page(CreateAccountPage.class);
    }

    public CreateAccountPage VerifyAlmostDonePage(String PageName) {
        $(VERIFY_ALMOST_DONE_PAGE_REDIRECTION).shouldHave(Condition.text(PageName));
        return page(CreateAccountPage.class);
    }

    public LoginPage VerifySuccessPage(String PageName) {
        $(VERIFY_SUCCESS_PAGE_REDIRECTION).shouldHave(Condition.text(PageName));
        return page(LoginPage.class);
    }

    public LoginPage VerifyActivateYourAccountPage(String PageName) {
        $(VERIFY_ACTIVATE_YOUR_ACCOUNT_PAGE_REDIRECTION).shouldHave(Condition.text(PageName));
        return page(LoginPage.class);
    }


}
