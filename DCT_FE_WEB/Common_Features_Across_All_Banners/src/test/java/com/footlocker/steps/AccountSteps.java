package com.footlocker.steps;


import EmailVerificationUtil.VerifyEmailThruRestApi;
import GoogleApiUtil.GoogleSheetData;
import Jenkins.JenkinsParamsVariable;
import com.codeborne.selenide.Selenide;
import com.footlocker.core.BaseSteps;
import com.footlocker.pages.CreateAccountPage;
import com.footlocker.pages.HomePage;
import com.footlocker.pages.RedirectionPage;
import cucumber.api.DataTable;

import static com.footlocker.core.BasePage.goToHomePage;

public class AccountSteps extends BaseSteps {


    public AccountSteps() {

        //  System.out.println("********* SHEET NAME ********" + JenkinsParamsVariable.GoogleDriveSpreadSheetName);
        //  System.out.println("********* ROW ********" + JenkinsParamsVariable.GoogleDriveSpreadSheetRowNumber);

        Given("^I am on the home page$", () -> update(goToHomePage()));

        When("^I click on Login Link$", () ->
                ((HomePage) page())
                        .DesktopBrowser_ClickOnLoginLink());

        Then("^It should give you Sign In Dialog box$", () ->
                ((HomePage) page())
                        .DesktopBrowser_VerifySignInDialogBox());

        And("^I click on Create an account link$", () ->
                update(((HomePage) page())
                        .ClickCreateAnAccountLinkFromSignInDialog()));

        // Old - with feature file
      /*  And("^I input list of below fields which are \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$",
                (String FirstName, String LastName, String Email, String Password, String MM, String DD, String YYYY) ->
                        // update(com.codeborne.selenide.Selenide.page(CreateAccountPage.class).InputCreateAccountFields(FirstName, LastName, Email, Password, MM, DD, YYYY)));
                        ((CreateAccountPage) page())
                                .InputCreateAccountFields(FirstName, LastName, Email, Password, MM, DD, YYYY));*/

        And("^I input required fields with an user input given from excel sheet \"([^\"]*)\" \"([^\"]*)\"$", (String SheetName, String FromRowToColSelection) ->
                ((CreateAccountPage) page())
                        .InputCreateAccountFields(SheetName, FromRowToColSelection));

      /*  And("^I choose skip VIP option or club rewards$", () ->
                ((CreateAccountPage) page())
                        .RadioSelectionSkipVIPOptionOrClubRewardsOption());*/

        And("^I choose user as \"([^\"]*)\" from excel sheet \"([^\"]*)\"$", (String RadioSelection, String ExcelSheetName) ->
                ((CreateAccountPage) page())
                        .RadioSelectionSkipVIPOptionOrClubRewardsOption(RadioSelection, ExcelSheetName));

        And("^I choose an user selection for VIP ClubMember Or To Skip it$", () ->
                ((CreateAccountPage) page())
                        .RadioSelectionSkipVIPOptionOrClubRewardsOption(
                                "I" + JenkinsParamsVariable.GoogleDriveSpreadSheetRowNumber + "",
                                JenkinsParamsVariable.GoogleDriveSpreadSheetName));

        And("^I choose english language$", () ->
                ((CreateAccountPage) page())
                        .RadioSelectionEnglishLanguage());

        And("^I click on Create an account button$", () ->
                update(((CreateAccountPage) page())
                        .ClickCreateAnAccountButton()));

        //  Then("^It should send an email to given email domain to verify new user$", () -> ((CreateAccountPage) page()).VerifyEmailSentMsg());

        // Email Verification
      /*  And("^I verify \"([^\"]*)\" received in given email domain with \"([^\"]*)\" and parse url from email to validate new user$",
                (String Email, String EmailSubject) ->
                        VerifyEmailThruRestApi.HitEmailDomainInbox_FetchEmailFromInbox_ParseClickHereUrlFromEmail(Email, EmailSubject));*/


        // New
        And("^I verify \"([^\"]*)\" received in given email domain with \"([^\"]*)\" from excel sheet \"([^\"]*)\" and parse url from email to validate new user$",
                (String Email, String EmailSubject, String ExchelSheetName) ->
                        VerifyEmailThruRestApi.HitEmailDomainInbox_FetchEmailFromInbox_ParseClickHereUrlFromEmail(Email, EmailSubject, ExchelSheetName));


        /* Option: 1
            Then("^I should given verification$", () -> Selenide.open("https://www.staging2.origin.ladyfootlocker.com/")); */
        /* Option: 2 */
        When("^I navigate to the url fetched from email to validate the user$", () ->
                SelenideConfiguration.driver.get(VerifyEmailThruRestApi.newUserValidationUrlFromEmail));

        And("^Finally once user has successfully been registered i will go ahead and highlight that row that start and end from \"([^\"]*)\" in given excel sheet \"([^\"]*)\"$",
                (String FromRowToColSelection, String ExcelSheetName) ->
                        GoogleSheetData.HighlightRowOnceUserRegistered(FromRowToColSelection, ExcelSheetName)
        );


        /* ======= From this line below are from Jenkins ======== */


        And("^I input required fields data from excel sheet based on the specific row$", () ->
                ((CreateAccountPage) page())
                        .InputCreateAccountFieldsBasedOnSpecificExcelRowData(
                                Integer.parseInt(JenkinsParamsVariable.GoogleDriveSpreadSheetRowNumber),
                                JenkinsParamsVariable.GoogleDriveSpreadSheetName));

        And("^I verify verification email received in given email domain and from that email i parse the html url thru which new user can be verified$", () ->
                VerifyEmailThruRestApi.HitEmailDomainInbox_FetchEmailFromInbox_ParseClickHereUrlFromEmail(
                        GoogleSheetData.getSpecificColFromGoogleSheet(
                                JenkinsParamsVariable.GoogleDriveSpreadSheetName,
                                "C",
                                Integer.parseInt(JenkinsParamsVariable.GoogleDriveSpreadSheetRowNumber)),

                        GoogleSheetData.getSpecificColFromGoogleSheet(
                                JenkinsParamsVariable.GoogleDriveSpreadSheetName,
                                "H",
                                Integer.parseInt(JenkinsParamsVariable.GoogleDriveSpreadSheetRowNumber)),
                        ""));

        And("^Finally once user has successfully been registered i will highlight that specific row in excel sheet to filter out$", () ->
                GoogleSheetData.HighlightRowOnceUserRegistered(
                        JenkinsParamsVariable.GoogleDriveSpreadSheetName,
                        Integer.parseInt(JenkinsParamsVariable.GoogleDriveSpreadSheetRowNumber)));

        And("^Finally once user has successfully been registered i will move that specific row to registered user spreadsheet$", () ->
                GoogleSheetData.CopySourceSheetDataToDestinationSheetOnceUserRegisteredSuccess(
                        JenkinsParamsVariable.GoogleDriveSpreadSheetName,
                        Integer.parseInt(JenkinsParamsVariable.GoogleDriveSpreadSheetRowNumber)));


    }


}
