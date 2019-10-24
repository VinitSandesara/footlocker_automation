package com.footlocker.pages;

import GoogleApiUtil.GoogleSheetData;
import com.codeborne.selenide.Condition;
import com.footlocker.core.BasePage;
import org.openqa.selenium.By;

import static SeleniumUtil.LocatorRepository.getLocator;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage extends BasePage {

    private final By INPUT_EMAIL_TEXTBOX = getLocator("Input.Email.TextBox");
    private final By INPUT_PASSWORD_TEXTBOX = getLocator("Input.Password.TextBox");
    private final By CLICK_SIGNIN_BUTTON = getLocator("Click.SignIn.Button");

   /* public LoginPage InputEmailTextbox(String Email) {
        $(INPUT_EMAIL_TEXTBOX).val(Email);
        return page(LoginPage.class);
    }*/

    public LoginPage InputEmailTextbox(String Email, String ExcelSheetName) {
        $(INPUT_EMAIL_TEXTBOX).val(GoogleSheetData.getSpecificRowColValueFromGoogleSheet(ExcelSheetName, Email));

        return page(LoginPage.class);
    }

    public LoginPage InputEmailTextbox(String SheetName, String Col, int row) {
      //  $(INPUT_EMAIL_TEXTBOX).val(GoogleSheetData.getSpecificRowColValueFromGoogleSheet(ExcelSheetName, Email));
        $(INPUT_EMAIL_TEXTBOX).val(GoogleSheetData.getSpecificColFromGoogleSheet(SheetName, Col, row));
        return page(LoginPage.class);
    }

   /* public LoginPage InputPasswordTextbox(String Password) {
        $(INPUT_PASSWORD_TEXTBOX).val(Password);
        return page(LoginPage.class);
    }*/

     public LoginPage InputPasswordTextbox(String Password, String ExcelSheetName) {
        $(INPUT_PASSWORD_TEXTBOX).val(GoogleSheetData.getSpecificRowColValueFromGoogleSheet(ExcelSheetName, Password));
        return page(LoginPage.class);
    }

    public LoginPage InputPasswordTextbox(String SheetName, String Col, int row) {
        $(INPUT_PASSWORD_TEXTBOX).val(GoogleSheetData.getSpecificColFromGoogleSheet(SheetName, Col, row));
        return page(LoginPage.class);
    }


    public HomePage ClickSignInButton() {

        // Post SSO
        $(CLICK_SIGNIN_BUTTON).click();

        // Pre sso
       // $$(CLICK_SIGNIN_BUTTON).get(1).click();

        return page(HomePage.class);
    }


}
