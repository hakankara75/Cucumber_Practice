package stepDefinitions.db_stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.sql.*;

import static org.junit.Assert.*;
import static utilities.DataBaseUtils.getResultSet;

public class US01_DB_StepDefinition {
    Connection connection;
    Statement statement;
    ResultSet resultSet;

    @Given("{string} ile guest useri cagir")
    public void ile_guest_useri_cagir(String username) throws SQLException {
        //connection ve statement olustur
//       connection= DriverManager.getConnection("jdbc:postgresql://managementonschools.com:5432/school_management", "select_user", "43w5ijfso");
//       statement= connection.createStatement();
/*
yukarisi icin DataBaseUtils'de 3 metot olusturduk
 */
       //query'yi calistir
        String query = "SELECT * FROM guest_user WHERE username = '"+username+"'";
//       resultSet = statement.executeQuery(query);
        /*
yukarisi icin DataBaseUtils'de 3 metot olusturduk. asagidaki getResultSet hepsini kapsar. 3. metotdur
 */
        resultSet= getResultSet(query);

    }
    @Then("body sunları icermeli: {string}, {string}, {string}, {string}, {string}, {string},{string}, {string}, {string}")
    public void body_sunlari_icermeli(String name, String surname, String birthplace, String phone, String gender, String dateOfBirth , String ssn, String username, String password) throws SQLException {
        resultSet.next();
        String actualUsername = resultSet.getString("username");
        String actualName = resultSet.getString("name");
        String actualSurname = resultSet.getString("surname");
        String actualBirthPlace = resultSet.getString("birth_place"); //sutun isimleri sql'deki gibi olmali birth_place gibi
        String actualPhone = resultSet.getString("phone_number");
        String actualGender = resultSet.getString("gender");
        String actualBirthDay = resultSet.getString("birth_day"); //sutun isimleri sql'deki gibi olmali birth_day gibi
        String actualSsn = resultSet.getString("ssn");

        assertEquals(username, actualUsername);
        assertEquals(name, actualName);
        assertEquals(surname, actualSurname);
        assertEquals(birthplace, actualBirthPlace);
        assertEquals(phone, actualPhone);
        assertEquals(gender, actualGender);
        assertEquals(dateOfBirth, actualBirthDay);
        assertEquals(ssn, actualSsn);
    }


    @Given("birthplace {string} ile quest useri cagir")
    public void birthplace_ile_quest_useri_cagir(String birthplace) throws SQLException {
        //connection ve statement olustur
        connection= DriverManager.getConnection("jdbc:postgresql://managementonschools.com:5432/school_management", "select_user", "43w5ijfso");
        statement= connection.createStatement();

        //query'yi calistir
        String query = "SELECT * FROM guest_user WHERE birth_place = '"+birthplace+"'";
        resultSet = statement.executeQuery(query);


    }
    @Then("kac tane user oldugunu bul")
    public void kac_tane_user_oldugunu_bul() throws SQLException {
        while (resultSet.next()) {

            System.out.println(resultSet.getString("name")+"--"+resultSet.getString("surname")+"--"+resultSet.getString("birth_place"));

        }
    }

    @Given("silinen {string} ile guest useri cagir")
    public void silinenIleGuestUseriCagir(String username) {

        String query = "SELECT * FROM guest_user WHERE username = '"+username+"'";
        resultSet = getResultSet(query);

    }

    @Then("tablein bos oldugunu dogrula")
    public void tableinBosOldugunuDogrula() throws SQLException {

        assertFalse(resultSet.next());

    }

}