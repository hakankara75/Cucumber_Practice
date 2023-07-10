package stepDefinitions.api_stepdefs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojos.US04_US05_Pojos.US04Pojo;
import pojos.US04_US05_Pojos.US04_OuterPojo;
import utilities.ObjectMapperUtils;

import static base_url.ManagementOnSchoolsBaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class US04_US05_API_StefDefinitions {
    Response response;
    US04_OuterPojo expectedDean;
    String userId;
    Faker faker = new Faker();

    @Given("Admin Tum Dean bilgilerini cagirir")
    public void adminTumDeanBilgileriniCagirir() {
        //set the url
        spec.pathParams("first", "dean", "second", "getAll");

        //send the request and get the response
        response = given(spec).get("{first}/{second}");
        //response.prettyPrint();

    }


    @Given("Admin Tum Dean bilgilerini post request yapar")
    public void adminTumDeanBilgileriniPostRequestYapar() {
        //set the url
        spec.pathParams("first", "dean", "second", "save");


    }

    @Then("Dean bodysi {string} {string} {string} {string} {string}  {string} {string} {string} {string} {string}API ile dogrulanir")
    public void deanBodysiAPIIleDogrulanir(String name, String surname, String birthPlace, String birthDay, String gender, String phoneNumber, String ssn, String username, String password, String userId) {
        //set the expected data
        US04Pojo us04Pojo = new US04Pojo(name, surname, birthPlace, birthDay, gender, phoneNumber, ssn, username, password, userId);
        expectedDean = new US04_OuterPojo(us04Pojo, null, null);


        //send the request and get the response
        response = given(spec).body(us04Pojo).post("{first}/{second}");
        response.prettyPrint();


        //do assertion
        US04_OuterPojo actualPostDean = ObjectMapperUtils.convertJsonToJava(response.asString(), US04_OuterPojo.class);

        assertEquals(200, response.statusCode());
        assertEquals(expectedDean.getObject().getName(), actualPostDean.getObject().getName());
        assertEquals(expectedDean.getObject().getSurname(), actualPostDean.getObject().getSurname());
        assertEquals(expectedDean.getObject().getBirthPlace(), actualPostDean.getObject().getBirthPlace());
        assertEquals(expectedDean.getObject().getBirthDay(), actualPostDean.getObject().getBirthDay());
        assertEquals(expectedDean.getObject().getGender(), actualPostDean.getObject().getGender());
        assertEquals(expectedDean.getObject().getPhoneNumber(), actualPostDean.getObject().getPhoneNumber());
        assertEquals(expectedDean.getObject().getSsn(), actualPostDean.getObject().getSsn());
        assertEquals(expectedDean.getObject().getUsername(), actualPostDean.getObject().getUsername());

    }

    @Given("Admin Tum Dean bilgilerini get request yapar")
    public void adminTumDeanBilgileriniGetRequestYapar() {
        //set the url
        spec.pathParams("first", "dean", "second", "getAll");

        //send the request and get the response
        response = given(spec).get("{first}/{second}");
        //response.prettyPrint();

    }


    @Given("Admin Ekledigi Dean bilgilerine get request yapar")
    public void adminEkledigiDeanBilgilerineGetRequestYapar() {

        //set the url
        spec.pathParams("first", "dean", "second", "getAll");

        //send the request and get the response
        response = given(spec).get("{first}/{second}");
        //response.prettyPrint();

    }

    @Then("Dean bodysi {string} {string} {string} {string} {string}  {string} {string} {string} {string} API ile get yaparak dogrulanir")
    public void deanBodysiAPIIleGetYaparakDogrulanir(String name, String surname, String birthPlace, String birthDay, String gender, String phoneNumber, String ssn, String username, String password) {
        //do assertion
        JsonPath jsonPath = response.jsonPath();
        Object actualName = jsonPath.getList("findAll{it.username=='" + username + "'}.name").get(0);
        Object actualSurname = jsonPath.getList("findAll{it.username=='" + username + "'}.surname").get(0);
        Object actualBirthDay = jsonPath.getList("findAll{it.username=='" + username + "'}.birthDay").get(0);
        Object actualSsn = jsonPath.getList("findAll{it.username=='" + username + "'}.ssn").get(0);
        Object actualBirthPlace = jsonPath.getList("findAll{it.username=='" + username + "'}.birthPlace").get(0);
        Object actualPhoneNumber = jsonPath.getList("findAll{it.username=='" + username + "'}.phoneNumber").get(0);
        Object actualGender = jsonPath.getList("findAll{it.username=='" + username + "'}.gender").get(0);
        Object actualUsername = jsonPath.getList("findAll{it.username=='" + username + "'}.username").get(0);

        assertEquals(200, response.statusCode());
        assertEquals(name, actualName);
        assertEquals(surname, actualSurname);
        assertEquals(birthDay, actualBirthDay);
        assertEquals(ssn, actualSsn);
        assertEquals(birthPlace, actualBirthPlace);
        assertEquals(phoneNumber, actualPhoneNumber);
        assertEquals(gender, actualGender);
        assertEquals(username, actualUsername);

    }

    @Given("Admin Silecegi Dean bilgilerini delete request yapar")
    public void adminSilecegiDeanBilgileriniDeleteRequestYapar() {

    }

    @Then("Silinen Dean bodysi {string} {string} {string} {string} {string}  {string} {string} {string} {string} {string} API ile dogrulanir")
    public void silinenDeanBodysiAPIIleDogrulanir(String name, String surname, String birthPlace, String birthDay, String gender, String phoneNumber, String ssn, String username, String password, String userId) {
        //set the url for POST
        spec.pathParams("first", "dean", "second", "save");

        //set the expected data for POST
        US04Pojo us04Pojo = new US04Pojo(name, surname, birthPlace, birthDay, gender, phoneNumber, ssn, username, password, userId);
        expectedDean = new US04_OuterPojo(us04Pojo, null, null);


        //send the request and get the response for POST
        response = given(spec).body(us04Pojo).post("{first}/{second}");
        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();
        userId = jsonPath.getString("object.userId");
        System.out.println("userId Post = " + userId);
        System.out.println("response.getStatusCode() = " + response.getStatusCode());

        //set the url for DELETE
        spec.pathParams("first", "dean", "second", "delete", "third", userId);


        //send the request and get the response for DELETE
        response = given(spec).delete("{first}/{second}/{third}");
        response.prettyPrint();

        //do assertion for DELETE
        jsonPath = response.jsonPath();
        String expectedMessage = "Dean Deleted";
        String expectedHttpStatus = "OK";
        String actualMessage = jsonPath.getString("message");
        String actualHttpStatus = jsonPath.getString("httpStatus");


        assertEquals(200, response.statusCode());
        assertEquals(expectedMessage, actualMessage);
        assertEquals(expectedHttpStatus, actualHttpStatus);

    }

    @Given("Admin bos veri gondererek Dean eklemek icin request yapar")
    public void adminBosVeriGondererekDeanEklemekIcinRequestYapar() {
        //set the url
        spec.pathParams("first", "dean", "second", "save");

    }

    @Then("Bos veri ile Dean bodysi {string} {string} {string} {string} {string} {string}  {string} {string} {string} {string} ekleyemedigi API ile dogrulanir")
    public void bosVeriIleDeanBodysiEkleyemedigiAPIIleDogrulanir(String no, String name, String surname, String birthPlace, String birthDay, String gender, String phoneNumber, String ssn, String username, String password) {
        faker = new Faker();

        if (name.equals("")) {
            name = "";
        } else {
            name = faker.name().firstName();
        }
        if (surname.equals("")) {
            surname = "";
        } else {
            surname = faker.name().lastName();
        }
        if (birthPlace.equals("")) {
            birthPlace = "";
        } else {
            birthPlace = "Ardahan";
        }
        if (birthDay.equals("")) {
            birthDay = "";
        } else {
            birthDay = "2001-01-01";
        }
        if (gender.equals("")) {
            gender = "";
        } else {
            gender = "0";
        }
        if (phoneNumber.equals("")) {
            phoneNumber = "";
        } else {
            phoneNumber = faker.numerify("###-###-#####");
        }
        if (ssn.equals("")) {
            ssn = "";
        } else {
            ssn = faker.idNumber().ssnValid();
        }
        if (username.equals("")) {
            username = "";
        } else {
            username = faker.name().username();
        }
        if (password.equals("")) {
            password = "";
        } else {
            password = "1235678";
        }
        //set the expected data
        US04Pojo us04Pojo = new US04Pojo(name, surname, birthPlace, birthDay, gender, phoneNumber, ssn, username, password, userId);
        expectedDean = new US04_OuterPojo(us04Pojo, null, null);


        //send the request and get the response
        response = given(spec).body(us04Pojo).post("{first}/{second}");
        response.prettyPrint();


        //do assertion
        JsonPath jsonPath = response.jsonPath();
        String expectedName = "Your name must consist of the characters .";
        String expectedName2 = "Your name should be at least 2 characters";

        String expectedSurname = "Your surname must consist of the characters .";
        String expectedSurname2 = "Your surname should be at least 2 characters";

        String expectedBirthPlace = "Your birth place should be at least 2 characters";
        String expectedBirthPlace2 = "Your birth place must consist of the characters .";

        String expectedGender = "You have entered an invalid value. Valid values are: MALE, FEMALE";

        String expectedBirthDay = "Your birth place must consist of the characters .";
        String expectedBirthDay2 = "Please enter your birthday";

        String expectedPhoneNumber = "Please enter valid phone number";
        String expectedPhoneNumber2 = "Phone number should be exact 12 characters";

        String expectedSsn = "Please enter valid SSN number";

        String expectedPassword = "Please enter your password as at least 8 characters";

        String expectedUsername = "Your username must consist of the characters .";
        String expectedUsername2 = "Your username should be at least 4 characters";


        assertEquals(400, response.statusCode());

        switch (no) {
            case "1":
                String actualName = jsonPath.get("validations.name").toString();
                if (actualName.contains("Your name must consist of the characters .")) {
                    assertEquals(expectedName, jsonPath.get("validations.name").toString());
                } else {
                    assertEquals(expectedName2, jsonPath.get("validations.name").toString());
                }

                break;
            case "2":
                String actualSurname = jsonPath.get("validations.surname").toString();
                if (actualSurname.contains("Your surname must consist of the characters .")) {
                    assertEquals(expectedSurname, jsonPath.get("validations.surname").toString());
                } else {
                    assertEquals(expectedSurname2, jsonPath.get("validations.surname").toString());
                }
                ;
                break;
            case "3":
                String actualBirthPlace = jsonPath.get("validations.birthPlace").toString();
                System.out.println("actualBirthPlace = " + actualBirthPlace);
                if (actualBirthPlace.contains("Your birth place should be at least 2 characters")) {
                    assertEquals(expectedBirthPlace, jsonPath.get("validations.birthPlace").toString());
                } else {
                    assertEquals(expectedBirthPlace2, jsonPath.get("validations.birthPlace").toString());
                }
                ;
                break;
            case "4":
                String actualGender = jsonPath.get("validations.gender").toString();
                if (actualGender.contains("Your birth must consist of the characters ."))
                    assertEquals(expectedGender, jsonPath.get("validations.gender").toString());
                break;
            case "5":
                String actualBirthDay = jsonPath.get("validations.birthDay").toString();
                if (actualBirthDay.contains("Your birth must consist of the characters .")) {
                    assertEquals(expectedBirthDay, jsonPath.get("validations.birthDay").toString());
                } else {
                    assertEquals(expectedBirthDay2, jsonPath.get("validations.birthDay").toString());
                }
                ;
                break;
            case "6":
                String actualPhoneNumber = jsonPath.get("validations.phoneNumber").toString();
                if (actualPhoneNumber.contains("Please enter valid phone number")) {
                    assertEquals(expectedPhoneNumber, jsonPath.get("validations.phoneNumber").toString());
                } else {
                    assertEquals(expectedPhoneNumber2, jsonPath.get("validations.phoneNumber").toString());
                }
                ;
                break;
            case "7":
                String actualSsn = jsonPath.get("validations.ssn").toString();
                if (actualSsn.contains("Your birth must consist of the characters ."))
                    assertEquals(expectedSsn, jsonPath.get("validations.ssn").toString());

                break;
            case "8":
                String actualUsername = jsonPath.get("validations.username").toString();
                if (actualUsername.contains("Your username must consist of the characters .")) {
                    assertEquals(expectedUsername, jsonPath.get("validations.username").toString());
                } else {
                    assertEquals(expectedUsername2, jsonPath.get("validations.username").toString());
                }
                ;
                break;
            case "9":
                String actualPassword = jsonPath.get("validations.phoneNumber").toString();
                if (actualPassword.contains("Your birth must consist of the characters ."))
                    assertEquals(expectedPassword, jsonPath.get("validations.password").toString());
                break;
            default:
                break;
        }

    }

    @Then("Invalid Ssn degerli Dean bodysi {string} {string} {string} {string} {string} {string}  {string} {string} {string} {string}{}\" ekleyemedigi API ile dogrulanir")
    public void ınvalidSsnDegerliDeanBodysiEkleyemedigiAPIIleDogrulanir(String no, String name, String surname, String birthPlace, String birthDay, String gender, String phoneNumber, String ssn, String username, String password, String userId) {
        faker = new Faker();

        name = faker.name().firstName();

        surname = faker.name().lastName();

        birthPlace = "Ardahan";

        birthDay = "2001-01-01";

        gender = "0";

        phoneNumber = faker.numerify("###-###-#####");

        switch (no) {
            case "1":
                ssn = faker.number().numberBetween(100, 999) + "," + faker.number().numberBetween(10, 99) + "," + faker.number().numberBetween(1000, 9999);
                System.out.println(ssn);
                break;
            case "2":
                ssn = faker.number().numberBetween(100, 999) + " " + faker.number().numberBetween(10, 99) + " " + faker.number().numberBetween(1000, 9999);
                System.out.println(ssn);
                break;
            case "3":
                ssn = faker.number().numberBetween(10, 99) + "-" + faker.number().numberBetween(100, 999) + "-" + faker.number().numberBetween(1000, 9999);
                System.out.println(ssn);
                break;
            case "4":
                ssn = faker.number().numberBetween(10, 99) + "," + faker.number().numberBetween(100, 999) + "," + faker.number().numberBetween(1000, 9999);
                System.out.println(ssn);
                break;
            case "5":
                ssn = faker.number().numberBetween(1000, 9999) + "," + faker.number().numberBetween(10, 99) + "," + faker.number().numberBetween(100, 999);
                System.out.println(ssn);
                break;
            case "6":
                ssn = faker.number().numberBetween(1000, 9999) + " " + faker.number().numberBetween(10, 99) + " " + faker.number().numberBetween(100, 999);
                System.out.println(ssn);
                break;
            case "7":
                ssn = faker.number().numberBetween(100, 999) + "-" + faker.number().numberBetween(10, 99) + "-" + faker.number().numberBetween(1000, 9999);
                System.out.println(ssn);
                break;
            default:
                break;
        }

        username = faker.name().username();

        password = "1235678";

        //set the expected data
        US04Pojo us04Pojo = new US04Pojo(name, surname, birthPlace, birthDay, gender, phoneNumber, ssn, username, password, null);
        expectedDean = new US04_OuterPojo(us04Pojo, null, null);

        //send the request and get the response
        response = given(spec).body(us04Pojo).post("{first}/{second}");
        response.prettyPrint();

        //do assertion
        US04_OuterPojo actualPostDean = ObjectMapperUtils.convertJsonToJava(response.asString(), US04_OuterPojo.class);

        String expectedSsn = expectedDean.getObject().getSsn();
        System.out.println("expectedSsn" + expectedSsn.toString());



//        assertEquals(400, response.statusCode());
        if (no.contains("7")) {
            assertEquals(expectedDean.getObject().getSsn(), actualPostDean.getObject().getSsn());

        }


    }

}
