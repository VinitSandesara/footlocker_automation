package com.footlocker.steps;

import EmailVerificationUtil.VerifyEmailThruRestApi;
import ExtentReport.ExtentManager;
import ExtentReport.ExtentTestManager;
import GoogleApiUtil.GoogleSheetData;
import Jenkins.JenkinsParamsVariable;
import com.aventstack.extentreports.Status;
import com.codeborne.selenide.Configuration;
import com.footlocker.core.BaseSteps;
import com.footlocker.pages.CreateAccountPage;
import com.footlocker.pages.HomePage;
import com.footlocker.pages.LoginPage;
import com.footlocker.pages.RedirectionPage;
import io.cucumber.java8.En;


import java.util.List;

import static com.footlocker.core.BasePage.goToHomePage;

public class RegisterMultiUserSteps extends BaseSteps {

    int StartingRowIndex = 2;
    int rowIndex = 2;
    public List<List<Object>> RowDataFromExcel;
    public int i = 0;

    public RegisterMultiUserSteps() {


        And("^I register list of users whose runmode is Y in google spreadsheet \"([^\"]*)\" for banners FS and EB$", (String gSheetName) -> {


            /* Register multiple users in one go with Runmode is Y */

            String scenario = Hooks.getScenario().getName();

            RowDataFromExcel = GoogleSheetData.getGoogleSheetFilledCellData(gSheetName);

            for (i = 0; i <= RowDataFromExcel.size(); i++) {

                if (StartingRowIndex != RowDataFromExcel.size() + 2) {

                    if (GoogleSheetData.getCellValueBasedOnColumnName(gSheetName, StartingRowIndex, "Runmode").equalsIgnoreCase("Y")) {

                        // ExtentTestManager.getTest(scenario).log(Status.PASS, "Scenario " + scenario + " passed");
                        // Hooks.getScenario().write("<<<===========>>>" + scenario);

                        String UserEmail = GoogleSheetData.getCellValueBasedOnColumnName(gSheetName, StartingRowIndex, "Email");
                        Configuration.baseUrl = GoogleSheetData.getCellValueBasedOnColumnName(gSheetName, StartingRowIndex, "Banner");

                        SelenideConfiguration.driver.get(Configuration.baseUrl);

                        update(goToHomePage(Hooks.getScenario(), UserEmail)
                                .DesktopBrowser_ClickOnLoginLink()
                                .DesktopBrowser_VerifySignInDialogBox()
                                .ClickCreateAnAccountLinkFromSignInDialog()
                                .VerifyCreateAnAccountPage("Create Account")

                                .InputCreateAccountFieldsBasedOnSpecificExcelRowData(
                                        StartingRowIndex,
                                        gSheetName,
                                        "FirstName,LastName,Email,Password,DOB_MM,DOB_DD,DOB_YYYY")
                                .ClickCreateAnAccountButton()
                                .VerifyAlmostDonePage("Almost Done"));

                        VerifyEmailThruRestApi.HitEmailDomainInbox_FetchEmailFromInbox_ParseClickHereUrlFromEmail(
                                GoogleSheetData.getCellValueBasedOnColumnName(
                                        gSheetName,
                                        StartingRowIndex,
                                        "Email"),

                                GoogleSheetData.getCellValueBasedOnColumnName(
                                        gSheetName,
                                        StartingRowIndex,
                                        "EmailSubject"),

                                gSheetName);

                        SelenideConfiguration.driver.get(VerifyEmailThruRestApi.newUserValidationUrlFromEmail);

                        update(com.codeborne.selenide.Selenide.page(RedirectionPage.class)
                                .VerifySuccessPage("Success!")

                                .InputEmailTextbox(
                                        GoogleSheetData.getCellValueBasedOnColumnName(
                                                gSheetName,
                                                StartingRowIndex,
                                                "Email"))

                                .InputPasswordTextbox(
                                        GoogleSheetData.getCellValueBasedOnColumnName(
                                                gSheetName,
                                                StartingRowIndex,
                                                "Password"))


                                .ClickSignInButton(
                                        GoogleSheetData.getCellValueBasedOnColumnName(
                                                gSheetName,
                                                StartingRowIndex,
                                                "EmailSubject"))


                                .LogOut());


                        GoogleSheetData.CopySourceSheetDataToDestinationSheetOnceUserRegisteredSuccess(gSheetName, StartingRowIndex);


                        i--;
                        RowDataFromExcel = GoogleSheetData.getGoogleSheetFilledCellData(gSheetName);
                    } else {
                        GoogleSheetData.HighlightRowOnceUserRegistered(
                                gSheetName,
                                StartingRowIndex,
                                1091307946, "I");
                        StartingRowIndex++;
                    }
                } else {
                    System.out.println("Hello");
                    break;
                }


            }


        });


        And("^I register list of users whose runmode is Y in google spreadsheet \"([^\"]*)\" for banners FL, LFL, FA and CS$", (String gSheetName) -> {


            /* Register multiple users in one go with Runmode is Y */

            String scenario = Hooks.getScenario().getName();

            RowDataFromExcel = GoogleSheetData.getGoogleSheetFilledCellData(gSheetName);

            for (i = 0; i <= RowDataFromExcel.size(); i++) {

                if (StartingRowIndex != RowDataFromExcel.size() + 2) {


                    if (GoogleSheetData.getCellValueBasedOnColumnName(gSheetName, StartingRowIndex, "Runmode").equalsIgnoreCase("Y")) {

                        /* ExtentTestManager.startTest(scenario);
                        // ExtentTestManager.startTestUsingNode(scenario);
                        // ExtentTestManager.getTest(scenario).log(Status.PASS, "Scenario " + scenario + " passed");
                        Hooks.getScenario().write("<<<===========>>>" + scenario);
                        ExtentTestManager.endTest();
                        ExtentManager.getInstance().flush(); */


                        String UserEmail = GoogleSheetData.getCellValueBasedOnColumnName(gSheetName, StartingRowIndex, "Email");
                        Configuration.baseUrl = GoogleSheetData.getCellValueBasedOnColumnName(gSheetName, StartingRowIndex, "Banner");

                        SelenideConfiguration.driver.get(Configuration.baseUrl);

                        update(goToHomePage(Hooks.getScenario(), UserEmail)
                                .DesktopBrowser_ClickOnLoginLink()
                                .DesktopBrowser_VerifySignInDialogBox()
                                .ClickCreateAnAccountLinkFromSignInDialog()
                                .VerifyCreateAnAccountPage("Create Account")

                                .InputCreateAccountFieldsBasedOnSpecificExcelRowData(
                                        StartingRowIndex,
                                        gSheetName,
                                        "FirstName,LastName,Email,Password,DOB_MM,DOB_DD,DOB_YYYY")
                                .RadioSelectionSkipVIPOptionOrClubRewardsOption(
                                        GoogleSheetData.getCellValueBasedOnColumnName(
                                                gSheetName,
                                                StartingRowIndex,
                                                "VIP_ClubRewards_Or_Skip"
                                        ))
                                .ClickCreateAnAccountButton()
                                .VerifyAlmostDonePage("Almost Done"));

                        VerifyEmailThruRestApi.HitEmailDomainInbox_FetchEmailFromInbox_ParseClickHereUrlFromEmail(
                                GoogleSheetData.getCellValueBasedOnColumnName(
                                        gSheetName,
                                        StartingRowIndex,
                                        "Email"),

                                GoogleSheetData.getCellValueBasedOnColumnName(
                                        gSheetName,
                                        StartingRowIndex,
                                        "EmailSubject"),

                                gSheetName);

                        SelenideConfiguration.driver.get(VerifyEmailThruRestApi.newUserValidationUrlFromEmail);

                        update(com.codeborne.selenide.Selenide.page(RedirectionPage.class)
                                .VerifySuccessPage("Success!")

                                .InputEmailTextbox(
                                        GoogleSheetData.getCellValueBasedOnColumnName(
                                                gSheetName,
                                                StartingRowIndex,
                                                "Email"))

                                .InputPasswordTextbox(
                                        GoogleSheetData.getCellValueBasedOnColumnName(
                                                gSheetName,
                                                StartingRowIndex,
                                                "Password"))


                                .ClickSignInButton(
                                        GoogleSheetData.getCellValueBasedOnColumnName(
                                                gSheetName,
                                                StartingRowIndex,
                                                "EmailSubject"))


                                .LogOut());


                        GoogleSheetData.CopySourceSheetDataToDestinationSheetOnceUserRegisteredSuccess(gSheetName, StartingRowIndex);

                        i--;
                        RowDataFromExcel = GoogleSheetData.getGoogleSheetFilledCellData(gSheetName);
                    } else {
                        GoogleSheetData.HighlightRowOnceUserRegistered(
                                gSheetName,
                                StartingRowIndex,
                                639893326, "J");
                        StartingRowIndex++;
                    }
                } else {
                    System.out.println("Hello");
                    break;
                }


            }


        });


    }


}
