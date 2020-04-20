Feature: Exercise 1

  @Test-1
  Scenario: Home page test
    Given I open JDI GitHub site
    When I login as user 'Roman' with password 'Jdi1234' on the Home page
    Then username should be 'ROMAN IOVLEV' on the Home page
    And title 'Home Page' should be displayed on the Home page
    When I click on 'SERVICE' button in Header
    And I click on 'DIFFERENT ELEMENTS' button in Service dropdown
    Then Checkboxes should be displayed on Different elements page
    And radiobuttons should be displayed on Different elements page
    And dropdown should be displayed on Different elements page
    When I click 'Water' checkbox
    Then Log row should contain element name 'Water' and its value changed to 'true'
    When I click 'Wind' checkbox
    Then Log row should contain element name 'Wind' and its value changed to 'true'
    When I click 'Selen' radiobutton
    Then Log row should contain element name 'metal' and its value changed to 'Selen'
    When I select 'Yellow' dropdown
    Then Log row should contain element name 'Colors' and its value changed to 'Yellow'

