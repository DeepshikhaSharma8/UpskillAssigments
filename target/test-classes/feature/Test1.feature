Feature: Upskill website signUp to send a message.

  Scenario: SignUp on Upskill and send a message.
    Given Launch the website http://elearningm1.upskills.in/index.php
    When I click on signUp
    Then I fill up the registeration Form for all mandatory fields
      | Firstname       | Deepshikha       |
      | Lastname        | Sharma           |
      | Email           | xudaaa@gmail.com |
      | Username        | deepsharmaaaa    |
      | Password        | xyz              |
      | ConfirmPassword | xyz              |
    And Submit the details
    Then Verify the Message "Your personal settings have been registered."
    And Click on Next
    When I am on HomePage, click on username
    And Choose profile from Dropdown
    And Click on Messages
    And Click on Compose message
    And Enter the details shown on the page
      | SendTo  | xyz |
      | Subject | abc |
    Then Click on Send message
