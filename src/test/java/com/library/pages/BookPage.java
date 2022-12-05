package com.library.pages;

import com.library.utility.Driver;
import com.library.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class BookPage extends CommonAreaPage {

    @FindBy(xpath = "//table/tbody/tr")
    public List<WebElement> allRows;

    @FindBy(xpath = "//input[@type='search']")
    public WebElement search;

    @FindBy(id = "book_categories")
    public WebElement mainCategoryElement;

    @FindBy (xpath = "//select[@id='book_group_id']")
    public WebElement bookCategoryDropdown;

    @FindBy(xpath = "//table/tbody/tr[1]/td")
    public List<WebElement> newBookInfo;

    public String getSelectedOption(WebElement e){
        Select select = new Select(e);
        return select.getFirstSelectedOption().getText();
    }

    @FindBy(xpath = "//a[normalize-space(.)='Add Book']")
    public WebElement addBookButton;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement saveChangesButton;

    @FindBy(css = " .toast-message")
    public WebElement bookToastMessage;


    @FindBy(name = "name")
    public WebElement bookName;


    @FindBy(xpath = "(//input[@type='text'])[4]")
    public WebElement author;


    @FindBy(name = "year")
    public WebElement year;

    @FindBy(name = "isbn")
    public WebElement isbn;

    @FindBy(id = "description")
    public WebElement description;



    public WebElement editBook(String book) {
        String xpath = "//td[3][.='" + book + "']/../td/a";
        return Driver.getDriver().findElement(By.xpath(xpath));
    }




}
