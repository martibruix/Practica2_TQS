Feature: Contact

Scenario: Send Message

Given the user is in the index page
When the user clicks the contact option
And the user enters mail in contact email
And the user enters name in contact name
And the user enters the message in message
And the user clicks the send message button
Then the contact pop up message appears