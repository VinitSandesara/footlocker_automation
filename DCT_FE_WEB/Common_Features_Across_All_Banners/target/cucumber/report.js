$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/RegisterNewUser.feature");
formatter.feature({
  "line": 1,
  "name": "Account",
  "description": "",
  "id": "account",
  "keyword": "Feature"
});
formatter.before({
  "duration": 7434310819,
  "status": "passed"
});
formatter.scenario({
  "line": 5,
  "name": "Register post SSO ES or EB or both single user",
  "description": "",
  "id": "account;register-post-sso-es-or-eb-or-both-single-user",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 4,
      "name": "@Register_PostSSO_FS_EB_Single_User"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "I am on the home page",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "I click on Login Link",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "It should give you Sign In Dialog box",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "I click on Create an account link",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "It should redirects to Create Account page",
  "keyword": "Then ",
  "doc_string": {
    "content_type": "",
    "line": 12,
    "value": "Create Account"
  }
});
formatter.step({
  "line": 15,
  "name": "I input required fields data from excel sheet based on the specific row",
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "I click on Create an account button",
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "It should redirects to Almost Done page",
  "keyword": "Then ",
  "doc_string": {
    "content_type": "",
    "line": 18,
    "value": "Almost Done"
  }
});
formatter.step({
  "line": 21,
  "name": "I verify verification email received in given email domain and from that email i parse the html url thru which new user can be verified",
  "keyword": "And "
});
formatter.step({
  "line": 22,
  "name": "I navigate to the url fetched from email to validate the user",
  "keyword": "When "
});
formatter.step({
  "line": 23,
  "name": "It should redirects to Success page",
  "keyword": "Then ",
  "doc_string": {
    "content_type": "",
    "line": 24,
    "value": "Success!"
  }
});
formatter.step({
  "line": 28,
  "name": "I input email data from excel sheet in email textbox",
  "keyword": "And "
});
formatter.step({
  "line": 29,
  "name": "I input password data from excel sheet in password textbox",
  "keyword": "And "
});
formatter.step({
  "line": 30,
  "name": "I click on Sign In button to login into an account",
  "keyword": "And "
});
formatter.step({
  "line": 31,
  "name": "Finally once user has successfully been registered i will highlight that specific row in excel sheet to filter out",
  "keyword": "And "
});
formatter.match({
  "location": "AccountSteps.java:20"
});
formatter.result({
  "duration": 80474721,
  "status": "passed"
});
formatter.match({
  "location": "AccountSteps.java:22"
});
formatter.result({
  "duration": 214105621,
  "status": "passed"
});
formatter.match({
  "location": "AccountSteps.java:26"
});
formatter.result({
  "duration": 231164381,
  "status": "passed"
});
formatter.match({
  "location": "AccountSteps.java:30"
});
formatter.result({
  "duration": 191182181,
  "status": "passed"
});
formatter.match({
  "location": "PageRedirectionSteps.java:11"
});
formatter.result({
  "duration": 1572813968,
  "status": "passed"
});
formatter.match({
  "location": "AccountSteps.java:90"
});
formatter.result({
  "duration": 4187163677,
  "status": "passed"
});
formatter.match({
  "location": "AccountSteps.java:57"
});
formatter.result({
  "duration": 147700782,
  "status": "passed"
});
formatter.match({
  "location": "PageRedirectionSteps.java:16"
});
formatter.result({
  "duration": 2454527073,
  "status": "passed"
});
formatter.match({
  "location": "AccountSteps.java:93"
});
formatter.result({
  "duration": 37467082691,
  "status": "passed"
});
formatter.match({
  "location": "AccountSteps.java:78"
});
formatter.result({
  "duration": 2171938620,
  "status": "passed"
});
formatter.match({
  "location": "PageRedirectionSteps.java:19"
});
formatter.result({
  "duration": 1015734033,
  "status": "passed"
});
formatter.match({
  "location": "LoginSteps.java:35"
});
formatter.result({
  "duration": 3282790684,
  "status": "passed"
});
formatter.match({
  "location": "LoginSteps.java:39"
});
formatter.result({
  "duration": 416613271,
  "status": "passed"
});
formatter.match({
  "location": "LoginSteps.java:29"
});
formatter.result({
  "duration": 159033300,
  "status": "passed"
});
formatter.match({
  "location": "AccountSteps.java:99"
});
formatter.result({
  "duration": 39653718242,
  "status": "passed"
});
formatter.after({
  "duration": 75067636,
  "status": "passed"
});
});