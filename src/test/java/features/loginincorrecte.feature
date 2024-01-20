Feature: Log in incorrecte

Scenario: Error Message

Given the user is in the index page
When the user clicks the log in option
And the user enters log in username "a"
And the user enters log in password "b"
And the user clicks the log in button
Then the incorrect log in pop up message appears