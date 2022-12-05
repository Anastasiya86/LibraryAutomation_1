package com.library.step_definitions;

import com.library.utility.ConfigurationReader;
import com.library.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class US5_StepDefs_Anastasiya {


    @Given("Establish the database connection - AZ")
    public void establish_the_database_connection_az() {
    DB_Util.createConnection();
    }
    @When("I execute query to find most popular book genre - AZ")
    public void i_execute_query_to_find_most_popular_book_genre_az() {
        String query = "select bc.name ,count(*) from book_borrow bb\n" +
                "inner join books b on bb.book_id = b.id\n" +
                "inner join book_categories bc on b.book_category_id = bc.id\n" +
                "group by name\n" +
                "order by 2 desc limit 1";
        DB_Util.runQuery(query);
    }
    @Then("verify {string} is the most popular book genre. - AZ")
    public void verify_is_the_most_popular_book_genre_az(String actualBookGenre) {
        String expectedBookGenre = DB_Util.getFirstRowFirstColumn();
        System.out.println("expectedBookGenre = " + expectedBookGenre);
        Assert.assertEquals(expectedBookGenre,actualBookGenre);

        DB_Util.destroy();
    }
}
