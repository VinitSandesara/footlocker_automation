#Feature: Account

  # @Register @Register_New_User_For_FL_KFL_FA_CS_Backup
   #Scenario Outline: Verify the ability to register

 #    Given I am on the home page
  #   When I click on Login Link
   #  Then It should give you Sign In Dialog box
   #  And I click on Create an account link
    # Then It should redirects to Create Account page
   # """
   # Create Account
   # """
    # And I input list of below fields which are "<FirstName>" "<LastName>" "<Email>" "<Password>" "<DOB_MM>" "<DOB_DD>" "<DOB_YYYY>"
     #And I choose skip VIP option or club rewards
    # And I click on Create an account button
    # Then It should redirects to Almost Done page
  #  """
   # Almost Done
   # """
    # And I verify "<Email>" received in given email domain with "<EmailSubject>" and parse url from email to validate new user
    # When I navigate to the url fetched from email to validate the user
    # Then It should redirects to Success page
   # """
   # Success!
   # """
    # And I input "<Email>" in email textbox
     #And I input "<Password>" in password textbox
     #And I click on Sign In button to login into an account


     #Examples:
       #| FirstName | LastName | Email                                | Password   | DOB_MM | DOB_DD | DOB_YYYY | EmailSubject                   |
       #| First     | Last     | auto_stag_flca_non_vip_1@getnada.com | Test12345# | 11     | 22     | 1983     | Finish Activating Your Account |


 # @Register @Register_FS_EB
 # Scenario Outline: Verify the ability to register

 #   Given I am on the home page
 #   When I click on Login Link
 #   Then It should give you Sign In Dialog box
 #   And I click on Create an account link
 #   Then It should redirects to Create Account page
 #   """
 #   Create Account
 #   """
 #   And I input list of below fields which are "<FirstName>" "<LastName>" "<Email>" "<Password>" "<DOB_MM>" "<DOB_DD>" "<DOB_YYYY>"
 #   And I click on Create an account button
 #   Then It should redirects to Almost Done page
 #   """
 #   Almost Done
 #   """
 #   And I verify "<Email>" received in given email domain with "<EmailSubject>" and parse url from email to validate new user
 #   When I navigate to the url fetched from email to validate the user
 #   Then It should redirects to Success page
 #   """
 #   Success!
 #   """
 #   And I input "<Email>" in email textbox
 #   And I input "<Password>" in password textbox
 #   And I click on Sign In button to login into an account

  #  Examples:
  #    | FirstName | LastName | Email                               | Password   | DOB_MM | DOB_DD | DOB_YYYY | EmailSubject                   |
  #    | First     | Last     | auto_post_sso_stag_fs_1@getnada.com | Test12345# | 11     | 22     | 1983     | Finish Activating Your Account |


   #@Register @Register_New_User_For_FLCA
   #Scenario Outline: Verify the ability to register

     #Given I am on the home page
     #When I click on Login Link
     #Then It should give you Sign In Dialog box
     #And I click on Create an account link
     #Then It should redirects to Create Account page
   # """
   # Create Account
   # """
     #And I input list of below fields which are "<FirstName>" "<LastName>" "<Email>" "<Password>" "<DOB_MM>" "<DOB_DD>" "<DOB_YYYY>"
     #And I choose skip VIP option or club rewards
     #And I choose english language
     #And I click on Create an account button
     #Then It should redirects to Almost Done page
   # """
   # Almost Done
   # """
     #And I verify "<Email>" received in given email domain with "<EmailSubject>" and parse url from email to validate new user
     #When I navigate to the url fetched from email to validate the user
     #Then It should redirects to Activate your account page
   # """
   # Activate your account
   # """
     #And I input "<Email>" in email textbox
     #And I input "<Password>" in password textbox
     #And I click on Sign In button to login into an account


     #Examples:
       #| FirstName | LastName | Email                                        | Password   | DOB_MM | DOB_DD | DOB_YYYY | EmailSubject            |
       #| First     | Last     | auto_stag_flca_english_non_vip_3@getnada.com | Test12345# | 11     | 22     | 1983     | Your Foot Locker Canada |


 # @Debug
  #Scenario Outline: Debug
   # And I verify "<Email>" received in given email domain with "<EmailSubject>" and parse url from email to validate new user

   # Examples:
    #  | Email                                       | EmailSubject                   |
    #  | auto_post_sso_stag_cs_non_vip_3@getnada.com | Finish Activating Your Account |





