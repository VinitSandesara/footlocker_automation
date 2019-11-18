package com.footlocker.Backup_StepsDef;

import GoogleApiUtil.GoogleSheetData;
import com.footlocker.core.BaseSteps;
import com.footlocker.steps.Hooks;

import java.util.List;

public class RegisterMultiUserSteps extends BaseSteps {

    int StartingRowIndex = 2;
    int rowIndex = 2;
    public List<List<Object>> RowDataFromExcel;
    public int i = 0;

    public RegisterMultiUserSteps() {


        And("^I register list of users whose runmode is Y in google spreadsheet \"([^\"]*)\" for banners FS and EB$", (String gSheetName) -> {



            /* Register multiple users in one go if there wouldn't be Runmode in streadsheet

            List<List<Object>> RowDataFromExcel = GoogleSheetData.getGoogleSheetFilledCellData(JenkinsParamsVariable.GoogleDriveSpreadSheetName);


            for (List<Object> row : RowDataFromExcel) {


                Configuration.baseUrl = GoogleSheetData.getCellValueBasedOnColumnName(
                        JenkinsParamsVariable.GoogleDriveSpreadSheetName,
                        rowIndex,
                        "Banner"
                );

                SelenideConfiguration.driver.get(Configuration.baseUrl);

                update(goToHomePage()
                        .DesktopBrowser_ClickOnLoginLink()
                        .DesktopBrowser_VerifySignInDialogBox()
                        .ClickCreateAnAccountLinkFromSignInDialog()
                        .VerifyCreateAnAccountPage("Create Account")


                        // System.out.println("HARD STOP");

                        // update(com.codeborne.selenide.Selenide.page(CreateAccountPage.class)
                        .InputCreateAccountFieldsBasedOnSpecificExcelRowData(
                                rowIndex,
                                JenkinsParamsVariable.GoogleDriveSpreadSheetName,
                                "FirstName,LastName,Email,Password,DOB_MM,DOB_DD,DOB_YYYY")
                        .ClickCreateAnAccountButton()
                        .VerifyAlmostDonePage("Almost Done"));


                VerifyEmailThruRestApi.HitEmailDomainInbox_FetchEmailFromInbox_ParseClickHereUrlFromEmail(
                        GoogleSheetData.getCellValueBasedOnColumnName(
                                JenkinsParamsVariable.GoogleDriveSpreadSheetName,
                                rowIndex,
                                "Email"),

                        GoogleSheetData.getCellValueBasedOnColumnName(
                                JenkinsParamsVariable.GoogleDriveSpreadSheetName,
                                rowIndex,
                                "EmailSubject"),

                        JenkinsParamsVariable.GoogleDriveSpreadSheetName
                );

                SelenideConfiguration.driver.get(VerifyEmailThruRestApi.newUserValidationUrlFromEmail);


                update(com.codeborne.selenide.Selenide.page(RedirectionPage.class)
                        .VerifySuccessPage("Success!")

                        .InputEmailTextbox(
                                GoogleSheetData.getCellValueBasedOnColumnName(
                                        JenkinsParamsVariable.GoogleDriveSpreadSheetName,
                                        rowIndex,
                                        "Email"))

                        .InputPasswordTextbox(
                                GoogleSheetData.getCellValueBasedOnColumnName(
                                        JenkinsParamsVariable.GoogleDriveSpreadSheetName,
                                        rowIndex,
                                        "Password"))


                        .ClickSignInButton(
                                GoogleSheetData.getCellValueBasedOnColumnName(
                                        JenkinsParamsVariable.GoogleDriveSpreadSheetName,
                                        rowIndex,
                                        "EmailSubject"))


                        .LogOut());


                GoogleSheetData.CopySourceSheetDataToDestinationSheetOnceUserRegisteredSuccess(JenkinsParamsVariable.GoogleDriveSpreadSheetName, rowIndex);


            } */


        });


        And("^I register list of users whose runmode is Y in google spreadsheet \"([^\"]*)\" for banners FL, LFL, FA and CS$", (String gSheetName) -> {






             /* Register multiple users in one go if there wouldn't be Runmode in streadsheet

            List<List<Object>> RowDataFromExcel = GoogleSheetData.getGoogleSheetFilledCellData(JenkinsParamsVariable.GoogleDriveSpreadSheetName);


            for (List<Object> row : RowDataFromExcel) {


                Configuration.baseUrl = GoogleSheetData.getCellValueBasedOnColumnName(
                        JenkinsParamsVariable.GoogleDriveSpreadSheetName,
                        rowIndex,
                        "Banner"
                );

                SelenideConfiguration.driver.get(Configuration.baseUrl);

                update(goToHomePage(null, "")
                        .DesktopBrowser_ClickOnLoginLink()
                        .DesktopBrowser_VerifySignInDialogBox()
                        .ClickCreateAnAccountLinkFromSignInDialog()
                        .VerifyCreateAnAccountPage("Create Account")


                        // System.out.println("HARD STOP");

                        // update(com.codeborne.selenide.Selenide.page(CreateAccountPage.class)
                        .InputCreateAccountFieldsBasedOnSpecificExcelRowData(
                                rowIndex,
                                JenkinsParamsVariable.GoogleDriveSpreadSheetName,
                                "FirstName,LastName,Email,Password,DOB_MM,DOB_DD,DOB_YYYY")
                        .RadioSelectionSkipVIPOptionOrClubRewardsOption(
                                GoogleSheetData.getCellValueBasedOnColumnName(
                                        JenkinsParamsVariable.GoogleDriveSpreadSheetName,
                                        rowIndex,
                                        "VIP_ClubRewards_Or_Skip"
                                ))
                        .ClickCreateAnAccountButton()
                        .VerifyAlmostDonePage("Almost Done"));


                VerifyEmailThruRestApi.HitEmailDomainInbox_FetchEmailFromInbox_ParseClickHereUrlFromEmail(
                        GoogleSheetData.getCellValueBasedOnColumnName(
                                JenkinsParamsVariable.GoogleDriveSpreadSheetName,
                                rowIndex,
                                "Email"),

                        GoogleSheetData.getCellValueBasedOnColumnName(
                                JenkinsParamsVariable.GoogleDriveSpreadSheetName,
                                rowIndex,
                                "EmailSubject"),

                        JenkinsParamsVariable.GoogleDriveSpreadSheetName
                );

                SelenideConfiguration.driver.get(VerifyEmailThruRestApi.newUserValidationUrlFromEmail);


                update(com.codeborne.selenide.Selenide.page(RedirectionPage.class)
                        .VerifySuccessPage("Success!")

                        .InputEmailTextbox(
                                GoogleSheetData.getCellValueBasedOnColumnName(
                                        JenkinsParamsVariable.GoogleDriveSpreadSheetName,
                                        rowIndex,
                                        "Email"))

                        .InputPasswordTextbox(
                                GoogleSheetData.getCellValueBasedOnColumnName(
                                        JenkinsParamsVariable.GoogleDriveSpreadSheetName,
                                        rowIndex,
                                        "Password"))


                        .ClickSignInButton(
                                GoogleSheetData.getCellValueBasedOnColumnName(
                                        JenkinsParamsVariable.GoogleDriveSpreadSheetName,
                                        rowIndex,
                                        "EmailSubject"))


                        .LogOut());


                GoogleSheetData.CopySourceSheetDataToDestinationSheetOnceUserRegisteredSuccess(JenkinsParamsVariable.GoogleDriveSpreadSheetName, rowIndex);


            }  */



          /*  List<List<Object>> RowDataFromExcel = GoogleSheetData.getGoogleSheetFilledCellData(JenkinsParamsVariable.GoogleDriveSpreadSheetName);


            for (List<Object> row : RowDataFromExcel) {


                System.out.println("HARD STOP");

                update(com.codeborne.selenide.Selenide.page(CreateAccountPage.class)
                        .MultiUser_FillRequiredNewUserRegistrationForm(
                                String.valueOf(row.get(0)),
                                String.valueOf(row.get(1)),
                                String.valueOf(row.get(2)),
                                String.valueOf(row.get(3)),
                                String.valueOf(row.get(4)),
                                String.valueOf(row.get(5)),
                                String.valueOf(row.get(6))
                        )
                        /*  .RadioSelectionSkipVIPOptionOrClubRewardsOption(
                                  "I" + rowIndex + "",
                                  JenkinsParamsVariable.GoogleDriveSpreadSheetName)
                        .ClickCreateAnAccountButton()
                        .VerifyAlmostDonePage("Almost Done"));


                VerifyEmailThruRestApi.HitEmailDomainInbox_FetchEmailFromInbox_ParseClickHereUrlFromEmail(
                        GoogleSheetData.getSpecificColFromGoogleSheet(
                                JenkinsParamsVariable.GoogleDriveSpreadSheetName,
                                "C",
                                rowIndex),

                        GoogleSheetData.getSpecificColFromGoogleSheet(
                                JenkinsParamsVariable.GoogleDriveSpreadSheetName,
                                "H",
                                rowIndex),
                        "");

                SelenideConfiguration.driver.get(VerifyEmailThruRestApi.newUserValidationUrlFromEmail);

                update(com.codeborne.selenide.Selenide.page(RedirectionPage.class)
                        .VerifySuccessPage("Success!")
                        .InputEmailTextbox(
                                JenkinsParamsVariable.GoogleDriveSpreadSheetName,
                                "C",
                                rowIndex)

                        .InputPasswordTextbox(
                                JenkinsParamsVariable.GoogleDriveSpreadSheetName,
                                "D",
                                rowIndex)
                        .ClickSignInButton(
                                JenkinsParamsVariable.GoogleDriveSpreadSheetName,
                                "H",
                                rowIndex)
                        .LogOut()
                        .DesktopBrowser_ClickOnLoginLink()
                        .DesktopBrowser_VerifySignInDialogBox()
                        .ClickCreateAnAccountLinkFromSignInDialog()
                );

                GoogleSheetData.CopySourceSheetDataToDestinationSheetOnceUserRegisteredSuccess(JenkinsParamsVariable.GoogleDriveSpreadSheetName, rowIndex);
                //rowIndex++;

            } */


        });


    }


}
