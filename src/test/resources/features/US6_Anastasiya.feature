@wip
Feature: Books module
  As a librarian, I should be able to add new books to the library
@db
  Scenario Outline: Verify added book is matching with DB
    Given I login as a "librarian" -AZ
    And I navigate to "Books" page-AZ
    When the librarian click to add book-AZ
    And the librarian enter book name "<Book Name>" -AZ
    When the librarian enter ISBN "<ISBN>" -AZ
    And the librarian enter year "<Year>" -AZ
    When the librarian enter author "<Author>" -AZ
    And the librarian choose the book category "<Book Category>" -AZ
    And the librarian click to save changes -AZ
    Then "The book has been created." message should appear -AZ
    Then the librarian verify new book by "<Book Name>" -AZ
    Then the librarian verify new book from database by "<Book Name>" and "<Author>"-AZ

    Examples:
      | Book Name | ISBN | Year | Author | Book Category |
      | Clean Code Book | 9578124 | 2021 | Robert C.Martins | Drama |
      | Head First Javas | 10112021 | 2021 | Kathy Sierras | Action and Adventure |
      | The Scrum Field Guides | 11112021 | 2006 | Mitch Laceys | Short Story |