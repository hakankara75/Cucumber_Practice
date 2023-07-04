package stepDefinitions.api_stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
import static pages.base_urls.ManagementOnSchoolsBaseUrl.spec;

public class US04_US05_API_StefDefinitions {
    Response response;


    @Given("Admin Tum Dean bilgilerini cagirir")
    public void adminTumDeanBilgileriniCagirir() {
        //set the url
        spec.pathParams("first", "dean","second", "getAll");

        //send the request and get the response
        response = given(spec).get("{first}/{second}");
        //response.prettyPrint();

    }

    @Then("Dean bodysi {string} {string} {string} {string} {string}  {string} {string} {string} API ile dogrulanir")
    public void deanBodysiAPIIleDogrulanir(String name, String surname, String birthPlace, String dateOfBirth, String gender, String phone, String ssn, String username) {
        //do assertion
        JsonPath jsonPath= response.jsonPath();
        Object actualName= jsonPath.getList("findAll{it.username=='"+username+"'}.name").get(0);
        Object actualSurname= jsonPath.getList("findAll{it.username=='"+username+"'}.surname").get(0);
        Object actualBirthDay= jsonPath.getList("findAll{it.username=='"+username+"'}.birthDay").get(0);
        Object actualSsn= jsonPath.getList("findAll{it.username=='"+username+"'}.ssn").get(0);
        Object actualBirthPlace= jsonPath.getList("findAll{it.username=='"+username+"'}.birthPlace").get(0);
        Object actualPhoneNumber= jsonPath.getList("findAll{it.username=='"+username+"'}.phoneNumber").get(0);
        Object actualGender= jsonPath.getList("findAll{it.username=='"+username+"'}.gender").get(0);

        assertEquals(name, actualName);
        assertEquals(surname, actualSurname);
        assertEquals(dateOfBirth, actualBirthDay);
        assertEquals(ssn, actualSsn);
        assertEquals(birthPlace, actualBirthPlace);
        assertEquals(phone, actualPhoneNumber);
        assertEquals(gender, actualGender);

    }

    @Given("Admin Tum Dean bilgilerini post request yapar")
    public void adminTumDeanBilgileriniPostRequestYapar() {
        //set the url
        spec.pathParams("first", "dean","second", "save");

        //send the request and get the response
        response = given(spec).get("{first}/{second}");
        response.prettyPrint();

    }

    @Then("Dean bodysi {string} {string} {string} {string} {string}  {string} {string} {string} {string} API ile dogrulanir")
    public void deanBodysiAPIIleDogrulanir(String name, String surname, String birthPlace, String birthDay, String gender, String phoneNumber, String ssn, String username, String password) {
        //do assertion


    }
}
