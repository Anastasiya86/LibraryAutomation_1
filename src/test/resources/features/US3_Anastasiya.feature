
Feature: As a data consumer, I want UI and DB book categories are match.

Scenario: verify book categories with DB
    Given I login as a "librarian" -AZ
    When I navigate to "Books" page-AZ
    And I take all book categories in UI-AZ
    And I execute query to get book categories-AZ
    Then verify book categories must match book_categories table from db-AZ