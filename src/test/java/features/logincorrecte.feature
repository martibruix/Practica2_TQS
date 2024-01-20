Feature: Log in correcte

Scenario: Log in

Given the user is in the index page
When the user clicks the log in option
And the user enters log in username "a"
And the user enters log in password "a"
And the user clicks the log in button
Then the log out option appears
And the welcome "a" message appears