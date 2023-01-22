package dbStepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static utilities.DBUtils.*;

public class MyStepdefs {
    private static ResultSet resultSet;
    @Given("Local database baglantisi kurulur.")
    public void localDatabaseBaglantisiKurulur() {

        myCreateConnection();
    }
    @And("elemanlar listelenir")
    public void elemanlarListelenir() {
        List<List<Object>> staffIdList1=getQueryResultList("SELECT * FROM ogretmen_lisesi");

        staffIdList1.forEach(System.out::println);

    }



    @Then("listede {string} olup olmadığı dogrulanır")
    public void listedeOlupOlmadığıDogrulanır(String id) {
       List<Object> userIdList=getColumnData("SELECT * FROM ogretmen_lisesi","id");
       Assert.assertTrue(userIdList.toString().contains(id));
    }
}
