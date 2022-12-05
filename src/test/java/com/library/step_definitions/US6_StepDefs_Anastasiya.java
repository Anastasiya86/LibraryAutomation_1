package com.library.step_definitions;

import com.library.pages.BookPage;
import com.library.pages.DashBoardPage;
import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.*;

public class US6_StepDefs_Anastasiya {
    BookPage bookPage = new BookPage();
    String actualISBN,actualBookName,actualAuthorName,actualCategory,actualYear;

    @When("the librarian click to add book-AZ")
    public void the_librarian_click_to_add_book_az() {
    bookPage.addBookButton.click();

    }
    @When("the librarian enter book name {string} -AZ")
    public void the_librarian_enter_book_name_az(String bookName) {
    bookPage.bookName.sendKeys(bookName);

    }
    @When("the librarian enter ISBN {string} -AZ")
    public void the_librarian_enter_isbn_az(String isbn) {
    bookPage.isbn.sendKeys(isbn);

    }
    @When("the librarian enter year {string} -AZ")
    public void the_librarian_enter_year_az(String year) {
    bookPage.year.sendKeys(year);

    }
    @When("the librarian enter author {string} -AZ")
    public void the_librarian_enter_author_az(String author) {
    bookPage.author.sendKeys(author);

    }
    @When("the librarian choose the book category {string} -AZ")
    public void the_librarian_choose_the_book_category_az(String category) {
        bookPage.bookCategoryDropdown.sendKeys(category);

    }
    @When("the librarian click to save changes -AZ")
    public void the_librarian_click_to_save_changes_az() {
        BrowserUtil.waitFor(3);
        bookPage.saveChangesButton.click();

    }
    @Then("{string} message should appear -AZ")
    public void messageShouldAppearAZ(String expectedMessage) {
        BrowserUtil.waitFor(2);
        String actualMessage = bookPage.bookToastMessage.getText();
        Assert.assertEquals(expectedMessage,actualMessage);

    }
    @Then("the librarian verify new book by {string} -AZ")
    public void the_librarian_verify_new_book_by_az(String bookName) {
        bookPage.search.sendKeys(bookName+ Keys.ENTER);
        BrowserUtil.waitFor(3);


        List<String> list= new ArrayList<>();
        for (WebElement each : bookPage.newBookInfo) {
            list.add(each.getText());
        }
        list.remove(0);
        list.remove(list.size()-1);
        System.out.println(list);

         actualISBN = list.get(0);
         actualBookName = list.get(1);
        actualAuthorName = list.get(2);
         actualCategory = list.get(3);
         actualYear = list.get(4);


    }



    @Then("the librarian verify new book from database by {string} and {string}-AZ")
    public void theLibrarianVerifyNewBookFromDatabaseByAndAZ(String bookName, String author) {
        String query= "select b.id as id,b.name as name ,author,isbn,year,bc.name as category from books b\n" +
                "inner join  book_categories bc on b.book_category_id = bc.id\n" +
                "where b.name = '" + bookName + "' and author='" + author + "'\n" +
                "order by b.id desc";

        DB_Util.runQuery(query);
        BrowserUtil.waitFor(3);

        Map<String, String> bookInfo = DB_Util.getRowMap(1);
        BrowserUtil.waitFor(3);
        String expectedBookName = bookInfo.get("name");
        String expectedAuthorName = bookInfo.get("author");
        String expectedISBN = bookInfo.get("isbn");
        String expectedYear = bookInfo.get("year");
        String expectedCategory = bookInfo.get("category");


        Assert.assertEquals(expectedBookName,actualBookName);
        Assert.assertEquals(expectedAuthorName,actualAuthorName);
        Assert.assertEquals(expectedISBN,actualISBN);
        Assert.assertEquals(expectedYear,actualYear);
        Assert.assertEquals(actualCategory,expectedCategory);

    }
}
