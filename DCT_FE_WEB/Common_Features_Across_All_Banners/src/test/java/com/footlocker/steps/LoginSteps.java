package com.footlocker.steps;

import Jenkins.JenkinsParamsVariable;
import com.footlocker.core.BaseSteps;
import com.footlocker.pages.LoginPage;
import com.footlocker.pages.RedirectionPage;
import cucumber.api.java8.En;

public class LoginSteps extends BaseSteps {

    public LoginSteps() {

       /* And("^I input \"([^\"]*)\" in email textbox$", (String Email) ->
                ((LoginPage) page())
                        .InputEmailTextbox(Email));*/

        // New
        And("^I input \"([^\"]*)\" from excel sheet \"([^\"]*)\" in email textbox$", (String Email, String ExcelSheetName) ->
                ((LoginPage) page())
                        .InputEmailTextbox(Email, ExcelSheetName));

     /*   And("^I input \"([^\"]*)\" in password textbox$", (String Pass) ->
                ((LoginPage) page())
                        .InputPasswordTextbox(Pass));*/

        And("^I input \"([^\"]*)\" from excel sheet \"([^\"]*)\" in password textbox$", (String Password, String ExcelSheetName) ->
                ((LoginPage) page())
                        .InputPasswordTextbox(Password, ExcelSheetName));

        And("^I click on Sign In button to login into an account$", () ->
                ((LoginPage) page())
                        .ClickSignInButton(
                                JenkinsParamsVariable.GoogleDriveSpreadSheetName,
                                "H",
                                Integer.parseInt(JenkinsParamsVariable.GoogleDriveSpreadSheetRowNumber)));

        /* ======= From this line below are from Jenkins ======== */

        And("^I input email data from excel sheet in email textbox$", () ->
                ((LoginPage) page())
                        .InputEmailTextbox(
                                JenkinsParamsVariable.GoogleDriveSpreadSheetName,
                                "C",
                                Integer.parseInt(JenkinsParamsVariable.GoogleDriveSpreadSheetRowNumber)));

        And("^I input password data from excel sheet in password textbox$", () ->
                ((LoginPage) page())
                        .InputPasswordTextbox(
                                JenkinsParamsVariable.GoogleDriveSpreadSheetName,
                                "D",
                                Integer.parseInt(JenkinsParamsVariable.GoogleDriveSpreadSheetRowNumber)));


    }


}
