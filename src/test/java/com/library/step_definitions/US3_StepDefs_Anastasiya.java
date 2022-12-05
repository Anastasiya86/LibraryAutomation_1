package com.library.step_definitions;

import com.library.pages.BookPage;
import com.library.pages.CommonAreaPage;
import com.library.pages.LoginPage;
import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class US3_StepDefs_Anastasiya {
    LoginPage loginPage = new LoginPage();
    CommonAreaPage commonAreaPage = new CommonAreaPage();
    BookPage bookPage = new BookPage();
     List <String> actualCategoryList;
     List <String>  expectedCategoryList;

    @Given("I login as a {string} -AZ")
    public void i_login_as_a_az(String user) {
       loginPage.login(user);
    }
    @When("I navigate to {string} page-AZ")
    public void i_navigate_to_page_az(String module) {
       commonAreaPage.navigateModule(module);
    }
    @When("I take all book categories in UI-AZ")
    public void i_take_all_book_categories_in_ui_az() {

       WebElement allBookCategories= bookPage.mainCategoryElement;

       actualCategoryList = BrowserUtil.getAllSelectOptions(allBookCategories);
        actualCategoryList.remove(0);
        System.out.println("actualCategoryList = " + actualCategoryList);


    }
    @When("I execute query to get book categories-AZ")
    public void i_execute_query_to_get_book_categories_az() {
        String query = "select  name from book_categories";
        DB_Util.runQuery(query);
    }
    @Then("verify book categories must match book_categories table from db-AZ")
    public void verify_book_categories_must_match_book_categories_table_from_db_az() {
        expectedCategoryList= DB_Util.getColumnDataAsList(1);
        System.out.println("expectedCategoryList = " + expectedCategoryList);

        Assert.assertEquals(expectedCategoryList,actualCategoryList);
    }
}
