package stepDefinitions.E2E;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import pages.manage.Kisi_Ekleme_Guncelleme_Modulu;
import pages.manage.US04_US05_Dean_Ekleme_Guncelleme_Silme_Modulu;
import utilities.JdbcUtils;
import utilities.ReusableMethods;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.assertEquals;
import static stepDefinitions.api_stepdefs.US04_US05_API_StefDefinitions.response;
import static utilities.JdbcUtils.closeConnectionAndStatement;
import static utilities.JdbcUtils.executeQuery;

public class US04_US05_E2E_StepDefinitions extends Kisi_Ekleme_Guncelleme_Modulu {

    US04_US05_Dean_Ekleme_Guncelleme_Silme_Modulu admin = new US04_US05_Dean_Ekleme_Guncelleme_Silme_Modulu();
    static Faker faker = new Faker();
    static String name = faker.name().firstName();
    static String surname = faker.name().lastName();
    static String birthPlace = "Ardahan";
    static String birthDay = "2001-01-01";
    static String gender = "MALE";
    static String genderDb = "0";
    static String username = faker.name().username();
    static String ssn = faker.idNumber().ssnValid();
    static String phoneNumber = faker.numerify("###-###-####");
    static String password = "123456Aa";
    Connection connection;
    Statement statement;
    ResultSet resultSet;

    @Then("Admin Dean eklemek icin valid degerler girer")
    public void adminDeanEklemekIcinValidDegerlerGirer() {

        admin.name.sendKeys(name);
        admin.surname.sendKeys(surname);
        admin.birthPlace.sendKeys(birthPlace);
        admin.dateOfBirth.sendKeys(birthDay);
        admin.male.click();
        admin.ssn.sendKeys(ssn);
        admin.phoneNumber.sendKeys(phoneNumber);
        admin.password.sendKeys(password);
        admin.username.sendKeys(username);
        ReusableMethods.bekle(2);


    }


    @Then("Dean bodysi get yaparak API ile dogrulanir")
    public void deanBodysiGetYaparakAPIIleDogrulanir() {

        //do assertionresponse
        response.then().statusCode(200)
                .contentType(ContentType.JSON)
                .body("name", hasItem(name))
                .body("surname", hasItem(surname))
                .body("birthPlace", hasItem(birthPlace))
                .body("birthDay", hasItem(birthDay))
                .body("ssn", hasItem(ssn))
                .body("phoneNumber", hasItem(phoneNumber))
                .body("username", hasItem(username));


    }

    @Given("Admin Tum Dean bilgilerini DB'den cagirir")
    public void adminTumDeanBilgileriniDBDenCagirir() {
        //connection ve statement olustur
        JdbcUtils.connectToDataBase();
        JdbcUtils.createStatement();

        //query'i calistir
        String query = "SELECT * from dean where username ='" + username + "';";
        resultSet = executeQuery(query);
    }

    @Then("Dean bodysi DB'de dogrulanir")
    public void deanBodysiDBDeDogrulanir() throws SQLException {
        resultSet.next();
        String actualUsername = resultSet.getString("username");
        String actualName = resultSet.getString("name");
        String actualSurname = resultSet.getString("surname");
        String actualBirthPlace = resultSet.getString("birth_place");
        String actualGender = resultSet.getString("gender");
        String actualDateOfBirth = resultSet.getString("birth_day");
        String actualPhone = resultSet.getString("phone_number");
        String actualSsn = resultSet.getString("ssn");

        assertEquals(username, actualUsername);
        assertEquals(name, actualName);
        assertEquals(surname, actualSurname);
        assertEquals(birthPlace, actualBirthPlace);
        assertEquals(genderDb, actualGender);
        assertEquals(phoneNumber, actualPhone);
        assertEquals(ssn, actualSsn);

        closeConnectionAndStatement();
    }
}
