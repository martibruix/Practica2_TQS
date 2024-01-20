Feature: Place Order

Scenario: Place Order Product

Given the user is in the index page
When the user clicks the product image option
And the user clicks the Add to cart button
And the user clicks to close the pop up
And the user clicks the cart option
And the user clicks the Place Order option
And the user enters name in name
And the user enters the credit card in credit card
And the user clicks the Purchase button
Then the thanks pop up appears