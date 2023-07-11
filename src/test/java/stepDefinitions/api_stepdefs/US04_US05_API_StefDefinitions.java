package stepDefinitions.api_stepdefs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojo.US04_US05_Pojos.US04Pojo;
import pojo.US04_US05_Pojos.US04_OuterPojo;
import utilities.ObjectMapperUtils;
import utilities.US04_US05_Methods;
import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
import static pages.base_urls.ManagementOnSchoolsBaseUrl.spec;

public class US04_US05_API_StefDefinitions extends US04_US05_Methods {
    Response response;
    US04_OuterPojo expectedDean;
    US04Pojo us04Pojo;
    static String userId;
    Faker faker = new Faker();
    JsonPath jsonPath;

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

    @Then("Dean bodysi {string} {string} {string} {string} {string}  {string} {string} {string} {string} API ile dogrulanir")
    public void deanBodysiAPIIleDogrulanir(String name, String surname, String birthPlace, String birthDay, String gender, String phoneNumber, String ssn, String username, String password) {
        faker = new Faker();
        name = faker.name().firstName();
        surname = faker.name().lastName();
        phoneNumber = faker.numerify("###-###-####");
        ssn = faker.idNumber().ssnValid();
        username = faker.name().username();

        //set the expected data
        US04Pojo us04Pojo = new US04Pojo(name, surname, birthPlace, birthDay, gender, phoneNumber, ssn, username, password, userId);
        expectedDean = new US04_OuterPojo(us04Pojo, null, null);


        //send the request and get the response
        response =given(spec).body(us04Pojo).post("{first}/{second}");
        //response.prettyPrint();

        jsonPath = response.jsonPath();

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
        faker = new Faker();
        if (name.equals("<faker.name>")) {
            name = faker.name().firstName();
        }
        if (surname.equals("<faker.surname>")) {
            surname = faker.name().lastName();
        }
        if (phoneNumber.equals("<faker.phoneNumber>")) {
            phoneNumber = faker.numerify("###-###-####");
        }
        if (ssn.equals("<faker.ssn>")) {
            ssn = faker.idNumber().ssnValid();
        }
        if (username.equals("<faker.username>")) {
            username = faker.name().username();
        }

        //set the expecte data
        us04Pojo = new US04Pojo(name, surname, birthPlace, birthDay, gender, phoneNumber, ssn, username, password);

        //send the response get the request
        response = given(spec).body(us04Pojo).put("{first}/{second}/{third}");
        //response.prettyPrint();

        //do assertion
        jsonPath = response.jsonPath();
        String expectedMessage = "Dean updated Successful";
        String actualMessage = jsonPath.getString("message");
        String expectedStatus = "OK";
        String actualHttpStatus = jsonPath.getString("httpStatus");


        assertEquals(200, response.statusCode());
        assertEquals(expectedMessage, actualMessage);
        assertEquals(expectedStatus, actualHttpStatus);

    }

    @Given("Admin Silecegi Dean bilgilerini delete request yapar")
    public void adminSilecegiDeanBilgileriniDeleteRequestYapar() {

    }

    @Then("Silinen Dean bodysi {string} {string} {string} {string} {string}  {string} {string} {string} {string} {string} API ile dogrulanir")
    public void silinenDeanBodysiAPIIleDogrulanir(String name, String surname, String birthPlace, String birthDay, String gender, String phoneNumber, String ssn, String username, String password, String userId) {
        //set the url for DELETE
        spec.pathParams("first", "dean", "second", "delete", "third", userId);


        //send the request and get the response for DELETE
        response = given(spec).delete("{first}/{second}/{third}");
        //response.prettyPrint();

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
            gender = "MALE";
        }
        if (phoneNumber.equals("")) {
            phoneNumber = "";
        } else {
            phoneNumber = faker.numerify("###-###-####");
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
            password = "12345678";
        }
        //set the expected data
        US04Pojo us04Pojo = new US04Pojo(name, surname, birthPlace, birthDay, gender, phoneNumber, ssn, username, password, userId);
        expectedDean = new US04_OuterPojo(us04Pojo, null, null);


        //send the request and get the response
        response = given(spec).body(us04Pojo).post("{first}/{second}");
       // response.prettyPrint();


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

        gender = "MALE";

        phoneNumber = faker.numerify("###-###-####");

        switch (no) {
            case "1":
                ssn = faker.number().numberBetween(100, 999) + "," + faker.number().numberBetween(10, 99) + "," + faker.number().numberBetween(1000, 9999);
                break;
            case "2":
                ssn = faker.number().numberBetween(100, 999) + " " + faker.number().numberBetween(10, 99) + " " + faker.number().numberBetween(1000, 9999);
                break;
            case "3":
                ssn = faker.number().numberBetween(10, 99) + "-" + faker.number().numberBetween(100, 999) + "-" + faker.number().numberBetween(1000, 9999);
                break;
            case "4":
                ssn = faker.number().numberBetween(10, 99) + "," + faker.number().numberBetween(100, 999) + "," + faker.number().numberBetween(1000, 9999);
                break;
            case "5":
                ssn = faker.number().numberBetween(1000, 9999) + "," + faker.number().numberBetween(10, 99) + "," + faker.number().numberBetween(100, 999);
                break;
            case "6":
                ssn = faker.number().numberBetween(1000, 9999) + " " + faker.number().numberBetween(10, 99) + " " + faker.number().numberBetween(100, 999);
                break;
            case "7":
                ssn = faker.number().numberBetween(10, 99) + "," + faker.number().numberBetween(10, 99) + "," + faker.number().numberBetween(10000, 99999);
                break;
            case "8":
                ssn = faker.number().numberBetween(10, 99) + " " + faker.number().numberBetween(10, 99) + " " + faker.number().numberBetween(10000, 99999);
                break;
            default:
                break;
        }

        username = faker.name().username();

        password = "12345678";

        //set the expected data
        US04Pojo us04Pojo = new US04Pojo(name, surname, birthPlace, birthDay, gender, phoneNumber, ssn, username, password, null);
        expectedDean = new US04_OuterPojo(us04Pojo, null, null);

        //send the request and get the response
        response = given(spec).body(us04Pojo).post("{first}/{second}");
       // response.prettyPrint();

        //do assertion
        US04_OuterPojo actualPostDean = ObjectMapperUtils.convertJsonToJava(response.asString(), US04_OuterPojo.class);

        assertEquals(400, response.statusCode());

    }

    @Given("Admin Ekledigi Dean bilgilerine put request yapar")
    public void adminEkledigiDeanBilgilerinePutRequestYapar() {
        //set the url
        spec.pathParams("first", "dean", "second", "update", "third", userId);
    }


    @Given("Admin valid password ile Dean eklemek icin request yapar")
    public void adminValidPasswordIleDeanEklemekIcinRequestYapar() {
        //set the url
        spec.pathParams("first", "dean", "second", "save");
    }

    @Then("Valid Password degerli Dean bodysi {string} {string} {string} {string} {string}  {string} {string} {string} {string} ekledigi API ile dogrulanir")
    public void validPasswordDegerliDeanBodysiEkledigiAPIIleDogrulanir(String name, String surname, String birthPlace, String birthDay, String gender, String phoneNumber, String ssn, String username, String password) throws Throwable {    // Write code here that turns the phrase above into concrete actions    throw new cucumber.api.PendingException();}
        faker = new Faker();
        name = faker.name().firstName();
        System.out.println("olusan name = " + name);
        surname = faker.name().lastName();
        phoneNumber = faker.numerify("###-###-####");
        ssn = faker.idNumber().ssnValid();
        username = faker.name().username();
        password=faker.internet().password();

        //set the expected data
        US04Pojo us04Pojo = new US04Pojo(name, surname, birthPlace, birthDay, gender, phoneNumber, ssn, username, password, userId);
        expectedDean = new US04_OuterPojo(us04Pojo, null, null);


        //send the request and get the response
        response =given(spec).body(us04Pojo).post("{first}/{second}");
        response.prettyPrint();

        jsonPath = response.jsonPath();

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

    @Then("Invalid Password degerli Dean bodysi {string} {string} {string} {string} {string}  {string} {string} {string} {string} ekleyemedigi API ile dogrulanir")
    public void ınvalidPasswordDegerliDeanBodysiEkleyemedigiAPIIleDogrulanir(String name, String surname, String birthPlace, String birthDay, String gender, String phoneNumber, String ssn, String username, String password) {
        faker = new Faker();
        name = faker.name().firstName();
        System.out.println("olusan name = " + name);
        surname = faker.name().lastName();
        phoneNumber = faker.numerify("###-###-####");
        ssn = faker.idNumber().ssnValid();
        username = faker.name().username();

        //set the expected data
        US04Pojo us04Pojo = new US04Pojo(name, surname, birthPlace, birthDay, gender, phoneNumber, ssn, username, password, userId);
        expectedDean = new US04_OuterPojo(us04Pojo, null, null);


        //send the request and get the response
        response =given(spec).body(us04Pojo).post("{first}/{second}");
        response.prettyPrint();

        jsonPath = response.jsonPath();

        //do assertion
        US04_OuterPojo actualPostDean = ObjectMapperUtils.convertJsonToJava(response.asString(), US04_OuterPojo.class);

        assertEquals(400, response.statusCode());
    }
}