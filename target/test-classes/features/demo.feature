Feature: Test demo

@demo
Scenario Outline: I navigate to google
  Given I navigate to google home page
  Then google homepage should be loaded
  When I search for a string "<searchString>"
  Then first result should be "<result>"

  Examples:
  |searchString|result|
  |google co uk|https://www.google.co.uk/|
  |facebook|https://en-gb.facebook.com/|