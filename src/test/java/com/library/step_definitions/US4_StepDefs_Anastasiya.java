package com.library.step_definitions;

import com.library.pages.BookPage;
import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class US4_StepDefs_Anastasiya {
    BookPage bookPage= new BookPage();
    String bookName;

    @When("I open book {string}-AZ")
    public void i_open_book_az(String bookName) {
        BrowserUtil.waitForClickablility(bookPage.search, 5).sendKeys(bookName);
        BrowserUtil.waitForClickablility(bookPage.editBook(bookName), 5).click();
       this.bookName = bookName;

    }
    @Then("book information must match the Database-AZ")
    public void book_information_must_match_the_database_az() {
        BrowserUtil.waitFor(3);

        String actualBookName = bookPage.bookName.getAttribute("value");
        String actualAuthorName = bookPage.author.getAttribute("value");
        String actualISBN=bookPage.isbn.getAttribute("value");
        String actualYear = bookPage.year.getAttribute("value");
        BrowserUtil.waitFor(3);
        String actualBookCategory = bookPage.getSelectedOption(bookPage.bookCategoryDropdown);
        String actualDesc = bookPage.description.getAttribute("value");



        String query = "select b.name as name ,author,isbn,year,bc.name as category,b.description as description from books b\n" +
                "inner join  book_categories bc on b.book_category_id = bc.id\n" +
                "where b.name='"+bookName+"'";

        DB_Util.runQuery(query);

        Map <String, String> bookInfo = DB_Util.getRowMap(1);

        String expectedBookName = bookInfo.get("name");
        String expectedAuthorName = bookInfo.get("author");
        String expectedISBN = bookInfo.get("isbn");
        String expectedYear = bookInfo.get("year");
        String expectedBookCategory= bookInfo.get("category");
        String expectedDesc = bookInfo.get("description");


        Assert.assertEquals(expectedBookName,actualBookName);
        Assert.assertEquals(expectedAuthorName,actualAuthorName);
        Assert.assertEquals(expectedISBN,actualISBN);
        Assert.assertEquals(expectedYear,actualYear);
        Assert.assertEquals(expectedBookCategory,actualBookCategory);
        Assert.assertEquals(expectedDesc,actualDesc);
    }
}
