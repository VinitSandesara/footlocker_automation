package com.footlocker.pages;

import GoogleApiUtil.GoogleSheetData;

import com.codeborne.selenide.Condition;
import com.footlocker.core.BasePage;
import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.List;

import static SeleniumUtil.LocatorRepository.getLocator;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class CreateAccountPage extends BasePage {


    private final By CREATE_USER_FIRSTNAME_TEXTBOX = getLocator("CreateUser.Firstname.Textbox");
    private final By CREATE_USER_LASTNAME_TEXTBOX = getLocator("CreateUser.Lastname.Textbox");
    private final By CREATE_USER_EMAIL_TEXTBOX = getLocator("CreateUser.Email.Textbox");
    private final By CREATE_USER_PASSWORD_TEXTBOX = getLocator("CreateUser.Password.Textbox");
    private final By CREATE_USER_DOB_MM_TEXTBOX = getLocator("CreateUser.DOB.MM.Textbox");
    private final By CREATE_USER_DOB_DD_TEXTBOX = getLocator("CreateUser.DOB.DD.Textbox");
    private final By CREATE_USER_DOB_YYYY_TEXTBOX = getLocator("CreateUser.DOB.YYYY.Textbox");
    private final By CREATE_USER_SKIP_VIP_OR_CLUB_REWARDS_OPTION = getLocator("CreateUser.Skip.VIP.Or.Skip.Club.Rewards.RadioButton");
    private final By CREATE_USER_VIP_OR_CLUB_REWARDS_OPTION = getLocator("CreateUser.VIP.Or.Club.Rewards.RadioButton");

    private final By CREATE_USER_CREATE_AN_ACCOUNT_BUTTON = getLocator("CreateUser.CreateAnAccount.Button");
    private final By VERIFY_EMAIL_SENT_MSG = getLocator("Verify.Email.Sent.To.Verify.Msg");
    private final By CREATE_USER_ENGLISH_LANGUAGE_SELECTION = getLocator("CreateUser.English.Language.Selection");


  /*  public CreateAccountPage InputCreateAccountFields(String Firstname, String Lastname, String Email, String Pass, String MM, String DD, String YYYY) {
        $(CREATE_USER_FIRSTNAME_TEXTBOX).val(Firstname);
        $(CREATE_USER_LASTNAME_TEXTBOX).val(Lastname);
        $(CREATE_USER_EMAIL_TEXTBOX).val(Email);
        $(CREATE_USER_PASSWORD_TEXTBOX).val(Pass);
        $(CREATE_USER_DOB_MM_TEXTBOX).val(MM);
        $(CREATE_USER_DOB_DD_TEXTBOX).val(DD);
        $(CREATE_USER_DOB_YYYY_TEXTBOX).val(YYYY);

        return page(CreateAccountPage.class);
    }*/

    public CreateAccountPage InputCreateAccountFields(String SheetName, String FromRowToColSelection) {

        List<List<Object>> dataFromExcel = GoogleSheetData.getGoogleSheetData(SheetName, FromRowToColSelection);

        for (List<Object> row : dataFromExcel) {

            $(CREATE_USER_FIRSTNAME_TEXTBOX).val(String.valueOf(row.get(0)));
            $(CREATE_USER_LASTNAME_TEXTBOX).val(String.valueOf(row.get(1)));
            $(CREATE_USER_EMAIL_TEXTBOX).val(String.valueOf(row.get(2)));
            $(CREATE_USER_PASSWORD_TEXTBOX).val(String.valueOf(row.get(3)));
            $(CREATE_USER_DOB_MM_TEXTBOX).val(String.valueOf(row.get(4)));
            $(CREATE_USER_DOB_DD_TEXTBOX).val(String.valueOf(row.get(5)));
            $(CREATE_USER_DOB_YYYY_TEXTBOX).val(String.valueOf(row.get(6)));
        }

        return page(CreateAccountPage.class);
    }

    public CreateAccountPage InputCreateAccountFieldsBasedOnSpecificExcelRowData(int RowNumber, String SheetName) {

        List<List<Object>> RowDataFromExcel = GoogleSheetData.getSpecificRowFromGoogleSheet(SheetName, RowNumber);
        for (List<Object> row : RowDataFromExcel) {

            $(CREATE_USER_FIRSTNAME_TEXTBOX).val(String.valueOf(row.get(0)));
            $(CREATE_USER_LASTNAME_TEXTBOX).val(String.valueOf(row.get(1)));
            $(CREATE_USER_EMAIL_TEXTBOX).val(String.valueOf(row.get(2)));
            $(CREATE_USER_PASSWORD_TEXTBOX).val(String.valueOf(row.get(3)));
            $(CREATE_USER_DOB_MM_TEXTBOX).val(String.valueOf(row.get(4)));
            $(CREATE_USER_DOB_DD_TEXTBOX).val(String.valueOf(row.get(5)));
            $(CREATE_USER_DOB_YYYY_TEXTBOX).val(String.valueOf(row.get(6)));

        }
        return page(CreateAccountPage.class);

    }

     public CreateAccountPage InputCreateAccountFieldsBasedOnSpecificExcelRowData(int RowNumber, String SheetName, String ListOfRequiredFields) {

        HashMap<String, String> RowDataFromExcel = GoogleSheetData.getListOfCellValuesBasedOnColumnName(SheetName, RowNumber, ListOfRequiredFields);

            $(CREATE_USER_FIRSTNAME_TEXTBOX).val(RowDataFromExcel.get("FirstName"));
            $(CREATE_USER_LASTNAME_TEXTBOX).val(RowDataFromExcel.get("LastName"));
            $(CREATE_USER_EMAIL_TEXTBOX).val(RowDataFromExcel.get("Email"));
            $(CREATE_USER_PASSWORD_TEXTBOX).val(RowDataFromExcel.get("Password"));
            $(CREATE_USER_DOB_MM_TEXTBOX).val(RowDataFromExcel.get("DOB_MM"));
            $(CREATE_USER_DOB_DD_TEXTBOX).val(RowDataFromExcel.get("DOB_DD"));
            $(CREATE_USER_DOB_YYYY_TEXTBOX).val(RowDataFromExcel.get("DOB_YYYY"));

         getScenario.embed("<font size=\"5\" color=\"green\">Filled all required fields</font></b>".getBytes(),"text/html");

        return page(CreateAccountPage.class);

    }

    public CreateAccountPage MultiUser_FillRequiredNewUserRegistrationForm(String Firstname, String Lastname, String Email, String Pass, String DOB_MM, String DOB_DD, String DOB_YYYY) {

        $(CREATE_USER_FIRSTNAME_TEXTBOX).val(Firstname);
        $(CREATE_USER_LASTNAME_TEXTBOX).val(Lastname);
        $(CREATE_USER_EMAIL_TEXTBOX).val(Email);
        $(CREATE_USER_PASSWORD_TEXTBOX).val(Pass);
        $(CREATE_USER_DOB_MM_TEXTBOX).val(DOB_MM);
        $(CREATE_USER_DOB_DD_TEXTBOX).val(DOB_DD);
        $(CREATE_USER_DOB_YYYY_TEXTBOX).val(DOB_YYYY);

        return page(CreateAccountPage.class);

    }


    public CreateAccountPage RadioSelectionSkipVIPOptionOrClubRewardsOption() {

        $(CREATE_USER_SKIP_VIP_OR_CLUB_REWARDS_OPTION).click();
        return page(CreateAccountPage.class);
    }

    public CreateAccountPage RadioSelectionSkipVIPOptionOrClubRewardsOption(String RadioSelection) {

       // String UserRadioSelection = GoogleSheetData.getSpecificRowColValueFromGoogleSheet(ExcelSheetName, RadioSelection);

        if (RadioSelection.equalsIgnoreCase("SKIP")) {
            $(CREATE_USER_SKIP_VIP_OR_CLUB_REWARDS_OPTION).click();
        } else {
            $(CREATE_USER_VIP_OR_CLUB_REWARDS_OPTION).click();
        }
        return page(CreateAccountPage.class);
    }


    public RedirectionPage ClickCreateAnAccountButton() {
        $(CREATE_USER_CREATE_AN_ACCOUNT_BUTTON).click();
        getScenario.embed("<font size=\"5\" color=\"green\">Clicked on Create an account button</font></b>".getBytes(),"text/html");
        return page(RedirectionPage.class);
    }

    public RedirectionPage RadioSelectionEnglishLanguage() {
        $(CREATE_USER_ENGLISH_LANGUAGE_SELECTION).click();
        return page(RedirectionPage.class);
    }

    public CreateAccountPage VerifyEmailSentMsg() {
        $(VERIFY_EMAIL_SENT_MSG).shouldHave(Condition.text("Almost Done"));
        return page(CreateAccountPage.class);
    }


}
