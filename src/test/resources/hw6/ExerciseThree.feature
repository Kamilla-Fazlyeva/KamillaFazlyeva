Feature: Exercise 3

  @Test-3
  Scenario: Check vip checkbox
    Given I open JDI GitHub site
    And I login as user 'Roman' with password 'Jdi1234' on the Home page
    And I click on "SERVICE" button in Header
    And I click on "USER TABLE" button in Service dropdown
    When I select 'vip' checkbox for 'Sergey Ivan'
    Then 1 log row has 'Vip: condition changed to true' text in log section
