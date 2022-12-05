
Feature: Books module
  As a student, I should be able to borrow a book

  Scenario: Students borrow new books
    Given I login as a "student" -AZ
    And I navigate to "Books" page-AZ
    And I search book name called "Head First Java" -AZ
    When I click Borrow Book -AZ
    Then verify that book is shown in "Borrowing Books” page -AZ
    And verify logged student has same book in database -AZ