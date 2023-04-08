Feature: Login feature

  Scenario: User can't login using invalid credentials
    Given User is on the login page
    When User enter username "01757921769"
    And User enter password "......7"
    And User click on login button
    Then User see the message "Incorrect username or password."

  Scenario: User can't login using invalid phone number
    Given User is on the login page
    When User enter username "017w4587548"
    But User enter password ""
    And User click on login button
    Then User see the message "Please enter a valid phone number."

  Scenario: User can't login using unregister credentials
    Given User is on the login page
    When User enter username "01778681516"
    And User enter password "hijibiji"
    And User click on login button
    Then User see the message "Incorrect username or password."