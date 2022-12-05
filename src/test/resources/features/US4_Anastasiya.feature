
Feature: As a data consumer, I want UI and DB book information are match.

  Scenario: Verify book information with DB
    Given I login as a "librarian" -AZ
    And I navigate to "Books" page-AZ
    When I open book "Chordeiles minor"-AZ
    Then book information must match the Database-AZ