package com.footlocker.steps;

import com.footlocker.core.BaseSteps;
import com.footlocker.pages.RedirectionPage;
import cucumber.api.java8.En;

public class PageRedirectionSteps extends BaseSteps {


    public PageRedirectionSteps() {
        Then("^It should redirects to Create Account page$", (String PageName) ->
                update(((RedirectionPage) page())
                        .VerifyCreateAnAccountPage(PageName)));


        Then("^It should redirects to Almost Done page$", (String PageName) ->
                ((RedirectionPage) page())
                        .VerifyAlmostDonePage(PageName));
        When("^It should redirects to Success page$", (String PageName) ->
                update(((RedirectionPage) page())
                        .VerifySuccessPage(PageName)));

        Then("^It should redirects to Activate your account page$", (String PageName) ->
                update(((RedirectionPage) page())
                        .VerifyActivateYourAccountPage(PageName)));
    }


}
