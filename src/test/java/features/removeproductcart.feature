Feature: Remove product

Scenario: Remove product from Cart

Given the user is in the index page
When the user clicks the product image option
And the user clicks the Add to cart button
And the user clicks to close the pop up
And the user clicks the cart option
And the user clicks the delete option
Then the product is eliminated