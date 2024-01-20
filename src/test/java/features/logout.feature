Feature: Log out

Scenario: Log out

Given the user is in the index page
When the user clicks the log in option
And the user enters log in username "a"
And the user enters log in password "a"
And the user clicks the log in button
And the user clicks the log out option
Then the log in option appears
And the sign up option appears