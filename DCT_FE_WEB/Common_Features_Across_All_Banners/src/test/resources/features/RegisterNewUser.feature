Feature: New User Registration


# ========= POST SSO =============

  @Register_PostSSO_FS_EB_Single_User @NewUserRegister
  Scenario: Register post SSO ES or EB or both single user

    Given I am on the home page
    When I click on Login Link
    Then It should give you Sign In Dialog box
    And I click on Create an account link
    Then It should redirects to Create Account page
  """
  Create Account
  """
    And I input required fields which are "FirstName,LastName,Email,Password,DOB_MM,DOB_DD,DOB_YYYY" data from excel sheet
    And I click on Create an account button
    Then It should redirects to Almost Done page
  """
  Almost Done
  """
    And I verify "Email" received with "EmailSubject" in given email domain and from that email i parse the html url thru which new user can be verified
    When I navigate to the url fetched from email to validate the user
    Then It should redirects to Success page
  """
  Success!
  """

    And I input "Email" data from excel sheet in email textbox
    And I input "Password" data from excel sheet in password textbox
    And I click on Sign In button to login into an account
    And Finally once user has successfully been registered i will move that specific row to registered user spreadsheet


  @Register_PostSSO_For_FL_KFL_FA_CS_Single_User @NewUserRegister
  Scenario: Register post SSO FL KFL FA and CS or both single user

    Given I am on the home page
    When I click on Login Link
    Then It should give you Sign In Dialog box
    And I click on Create an account link
    Then It should redirects to Create Account page
  """
  Create Account
  """
    And I input required fields which are "FirstName,LastName,Email,Password,DOB_MM,DOB_DD,DOB_YYYY" data from excel sheet
    And I choose an user selection for "VIP_ClubRewards_Or_Skip"
    And I click on Create an account button
    Then It should redirects to Almost Done page
  """
  Almost Done
  """
    And I verify "Email" received with "EmailSubject" in given email domain and from that email i parse the html url thru which new user can be verified
    When I navigate to the url fetched from email to validate the user
    Then It should redirects to Success page
  """
  Success!
  """

    And I input "Email" data from excel sheet in email textbox
    And I input "Password" data from excel sheet in password textbox
    And I click on Sign In button to login into an account
    And Finally once user has successfully been registered i will move that specific row to registered user spreadsheet


# ========= POST SSO MULTI USERS CREATION =============

  @Register_PostSSO_FS_EB_Multi_User
  Scenario: Register Multiple users for banners FS and EB
    Given I register multiple users for banners FS and EB in one go which are mentioned in google spreadsheet


  @Register_PostSSO_FL_KFL_FA_CS_Multi_User
  Scenario: Register Multiple users for banners FL, LFL, FA and CS
    Given I register multiple users for banners FL, LFL, FA and CS in one go which are mentioned in google spreadsheet


# ========= PRE SSO =============

  @Register_PreSSO_FS_EB_Single_User
  Scenario: Register Pre SSO for ES EB single user

    Given I am on the home page
    When I click on Login Link
    Then It should give you Sign In Dialog box
    And I click on Create an account link
    Then It should redirects to Create Account page
  """
  Create Account
  """
    And I input required fields data from excel sheet based on the specific row
    And I click on Create an account button
    Then It should redirects to Almost Done page
  """
  Almost Done
  """
    And I verify verification email received in given email domain and from that email i parse the html url thru which new user can be verified
    When I navigate to the url fetched from email to validate the user
    Then It should redirects to Activate your account page
  """
  Activate your account
  """

    And I input email data from excel sheet in email textbox
    And I input password data from excel sheet in password textbox
    And I click on Sign In button to login into an account
    And Finally once user has successfully been registered i will highlight that specific row in excel sheet to filter out



  # ========= For Debug =============

  @Debug_PostSSO_FS @Debug_New_Single_User
  Scenario: Register post SSO ES
    And I am on the home page test "https://www.footlocker.com/"


  @Debug_PostSSO_FL @Debug_New_Single_User
  Scenario: Register post SSO FL
    And I am on the home page test "https://www.eastbay.com/"

  # ====================================================
