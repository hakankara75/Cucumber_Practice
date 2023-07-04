package stepDefinitions.db_stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.assertEquals;

public class US04_US05_DB_Admin_DeanleriEkleyebilmeli_GörebilmeliVeSilebilmeli extends JdbcUtils {

    Connection connection;
    Statement statement;
    ResultSet resultSet;
    @Given("{string} ile dean'i cagir")
    public void ileDeanICagir(String username) throws SQLException {
        //connection ve statement olustur
       JdbcUtils.connectToDataBase();
       JdbcUtils.createStatement();

        //query'i calistir
        String query= "SELECT * from dean where username ='"+username+"';";
        resultSet= executeQuery(query);
     }

    @Then("Dean bodysi {string} {string} {string} {string} {string} {string} {string} {string} dogrulanir")
    public void deanBodysi(String name, String surname, String birthPlace, String gender, String dateOfBirth, String phone, String ssn, String username) throws SQLException {
        resultSet.next();
        String actualUsername= resultSet.getString("username");
        String actualName= resultSet.getString("name");
        String actualSurname= resultSet.getString("surname");
        String actualBirthPlace= resultSet.getString("birth_place");
        String actualGender= resultSet.getString("gender");
        String actualDateOfBirth= resultSet.getString("birth_day");
        String actualPhone= resultSet.getString("phone_number");
        String actualSsn= resultSet.getString("ssn");

        assertEquals(username,actualUsername);
        assertEquals(name,actualName);
        assertEquals(surname,actualSurname);
        assertEquals(birthPlace,actualBirthPlace);
        assertEquals(gender,actualGender);
        assertEquals(dateOfBirth,actualDateOfBirth);
        assertEquals(phone,actualPhone);
        assertEquals(ssn,actualSsn);

        closeConnectionAndStatement();
    }

}
