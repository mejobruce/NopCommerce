Feature: Validate Register page

  Scenario Outline: Sucessfuly Regitration
    Given User on the registration page
    When User enter "<FirstName>"  and  "<LastName>"
    And user types in the "<email>" and "<ConfirmeEmail>"
    When user provides  "<UserName>"
    And User click on available button
    Then User shoud see avilabe message
    When User select country
    And User slect time
    And User click on NewsLetter checkbox
    When user inputs the "<password>"  and  "<confirmPassword>"
    And User select My company primarily
    And User  answer from plan to use nopCommerce
    And User click on My main activity in the company
    And User answer from How many people work for your company
    When User enter company webside "<WebsideNmae>"
    And User click on register button
    Then User should see success message

    Examples: 
      | FirstName | LastName | email               | ConfirmeEmail       | UserName | password      | confirmPassword | WebsideNmae          |
      | Mejo   | Seemone     | seemonemejo@gmail.com | seemonemejo@gmail.com | KDCK     | Mejo@06101991 | Mejo@06101991   | kdcktechnologies.com |
