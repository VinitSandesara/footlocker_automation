package com.footlocker.steps;

import EmailVerificationUtil.VerifyEmailThruRestApi;
import GoogleApiUtil.GoogleSheetData;
import Jenkins.JenkinsParamsVariable;
import com.footlocker.core.BaseSteps;
import com.footlocker.pages.CreateAccountPage;
import com.footlocker.pages.RedirectionPage;


import java.util.List;

public class RegisterMultiUserSteps extends BaseSteps {

    int rowIndex = 2;

    public RegisterMultiUserSteps() {
        And("^I register multiple users for banners FS and EB in one go which are mentioned in google spreadsheet$", () -> {

            List<List<Object>> RowDataFromExcel = GoogleSheetData.getGoogleSheetFilledCellData(JenkinsParamsVariable.GoogleDriveSpreadSheetName);


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

            }

        });


        And("^I register multiple users for banners FL, LFL, FA and CS in one go which are mentioned in google spreadsheet$", () -> {


            List<List<Object>> RowDataFromExcel = GoogleSheetData.getGoogleSheetFilledCellData(JenkinsParamsVariable.GoogleDriveSpreadSheetName);


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
                        .RadioSelectionSkipVIPOptionOrClubRewardsOption(
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

            }


        });


    }


}
