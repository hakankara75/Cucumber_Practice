package stepDefinitions.api_stepdefs;

import io.cucumber.java.en.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static pages.ManagementOnSchoolsBaseUrl.spec;


public class US01_ApiStepDefs {


    Response response;

    @Given("tum guest userlar icin get request yap")
    public void tum_guest_userlar_icin_get_request_yap() {
        //Set the url
        //https://managementonschools.com/app/guestUser/getAll?size=1000
        spec.pathParams("first", "guestUser", "second", "getAll")
                .queryParam("size", "1000");

        //Send the request and get the response
        response = given(spec).get("{first}/{second}");
        //response.prettyPrint();

    }
    @Then("gelen bodyi dogrula {string}, {string}, {string}, {string}, {string}, {string}, {string},{string}")
    public void gelen_bodyi_dogrula(String name, String surname, String birthplace, String phone, String gender, String dateOfBirth, String ssn, String username) {
        JsonPath jsonPath = response.jsonPath();

        Object actName = jsonPath.getList("content.findAll{it.username=='" + username + "'}.name").get(0);
        Object actUsername = jsonPath.getList("content.findAll{it.username=='" + username + "'}.username").get(0);
        Object actSsn = jsonPath.getList("content.findAll{it.username=='" + username + "'}.ssn").get(0);
        Object actSurname = jsonPath.getList("content.findAll{it.username=='" + username + "'}.surname").get(0);
        Object actBirthPlace = jsonPath.getList("content.findAll{it.username=='" + username + "'}.birthPlace").get(0);
        Object actPhone = jsonPath.getList("content.findAll{it.username=='" + username + "'}.phoneNumber").get(0);
        Object actGender = jsonPath.getList("content.findAll{it.username=='" + username + "'}.gender").get(0);
        Object actBirthDay = jsonPath.getList("content.findAll{it.username=='" + username + "'}.birthDay").get(0);

        assertEquals(name, actName);
        assertEquals(username, actUsername);
        assertEquals(ssn, actSsn);
        assertEquals(surname, actSurname);
        assertEquals(birthplace, actBirthPlace);
        assertEquals(phone, actPhone);
        assertEquals(gender, actGender);
        assertEquals(dateOfBirth, actBirthDay);


    }
}
