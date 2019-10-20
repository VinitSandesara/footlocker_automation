Feature: Account


  @Register_PostSSO_FS_EB_Single_User
  Scenario: Register post SSO ES or EB or both single user

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
     Then It should redirects to Success page
  """
  Success!
  """

      And I input email data from excel sheet in email textbox
      And I input password data from excel sheet in password textbox
      And I click on Sign In button to login into an account
      And Finally once user has successfully been registered i will highlight that specific row in excel sheet to filter out




  @Register_FS_EB
  Scenario Outline: Verify the ability to register

    Given I am on the home page
    When I click on Login Link
    Then It should give you Sign In Dialog box
    And I click on Create an account link
    Then It should redirects to Create Account page
  """
  Create Account
  """
    And I input required fields with an user input given from excel sheet "NewUser_FS_EB" "<From_RowNumber_TO_ColNumber>"
    And I click on Create an account button
    Then It should redirects to Almost Done page
  """
  Almost Done
  """
    And I verify "<Email>" received in given email domain with "<EmailSubject>" from excel sheet "NewUser_FS_EB" and parse url from email to validate new user
    When I navigate to the url fetched from email to validate the user

   # Post SSO Step
   # Then It should redirects to Success page
  #"""
  #Success!
  #"""

   # Pre SSO Step
    Then It should redirects to Activate your account page
    """
    Activate your account
    """

    And I input "<Email>" from excel sheet "NewUser_FS_EB" in email textbox
    And I input "<Password>" from excel sheet "NewUser_FS_EB" in password textbox
    And I click on Sign In button to login into an account
    And Finally once user has successfully been registered i will go ahead and highlight that row that start and end from "<From_RowNumber_TO_ColNumber>" in given excel sheet "<NewUser_FS_EB>"

    Examples:
      | From_RowNumber_TO_ColNumber | Email | Password | EmailSubject |
     # | A2:H2                       | C2    | D2       | H2           |
     # | A3:H3                       | C3    | D3       | H3           |
      | A14:H14                     | C14   | D14      | H14          |


  @Register_New_User_For_FL_KFL_FA_CS
  Scenario Outline: Verify the ability to register

    Given I am on the home page
    When I click on Login Link
    Then It should give you Sign In Dialog box
    And I click on Create an account link
    Then It should redirects to Create Account page
  """
  Create Account
  """
    And I input required fields with an user input given from excel sheet "NewUser_FL_KFL_FA_CS" "<From_RowNumber_TO_ColNumber>"
    And I choose user as "<VipClubRewardsOrSkip>" from excel sheet "NewUser_FL_KFL_FA_CS"
    And I click on Create an account button
    Then It should redirects to Almost Done page
  """
  Almost Done
  """
    And I verify "<Email>" received in given email domain with "<EmailSubject>" from excel sheet "NewUser_FL_KFL_FA_CS" and parse url from email to validate new user
    When I navigate to the url fetched from email to validate the user
    Then It should redirects to Success page
  """
  Success!
  """
    And I input "<Email>" from excel sheet "NewUser_FL_KFL_FA_CS" in email textbox
    And I input "<Password>" from excel sheet "NewUser_FL_KFL_FA_CS" in password textbox
    And I click on Sign In button to login into an account

    Examples:
      | From_RowNumber_TO_ColNumber | Email | Password | EmailSubject | VipClubRewardsOrSkip |
      | A2:H2                       | C2    | D2       | H2           | I2                   |


