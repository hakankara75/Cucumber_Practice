package utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Authentication {

    public static String generateTokenAdmin() {

        String body = "{ \"password\": \"12345678\", \"username\": \"Team10\" }";

        Response response = given()
                .body(body)
                .contentType(ContentType.JSON)
                .post("https://managementonschools.com/app/auth/login");
        //response.prettyPrint();
        return response.jsonPath().getString("token");
    }
    public static String generateTokenDean() {

        String body = "{ \"password\": \"12345678\", \"username\": \"deanhakan\" }";

        Response response = given()
                .body(body)
                .contentType(ContentType.JSON)
                .post("https://managementonschools.com/app/auth/login");
        //response.prettyPrint();
        return response.jsonPath().getString("token");
    }
    public static String generateTokenViceDean() {

        String body = "{ \"password\": \"12345678\", \"username\": \"vicedeanhakan\" }";

        Response response = given()
                .body(body)
                .contentType(ContentType.JSON)
                .post("https://managementonschools.com/app/auth/login");
        //response.prettyPrint();
        return response.jsonPath().getString("token");
    }
    public static String generateTokenTeacher() {

        String body = "{ \"password\": \"12345678\", \"username\": \"teacherhakan\" }";

        Response response = given()
                .body(body)
                .contentType(ContentType.JSON)
                .post("https://managementonschools.com/app/auth/login");
        //response.prettyPrint();
        return response.jsonPath().getString("token");
    }
    public static String generateTokenTeacher2() {

        String body = "{ \"password\": \"12345678\", \"username\": \"TeacherKemal\" }";

        Response response = given()
                .body(body)
                .contentType(ContentType.JSON)
                .post("https://managementonschools.com/app/auth/login");
        //response.prettyPrint();
        return response.jsonPath().getString("token");
    }
    public static String generateTokenStudent() {

        String body = "{ \"password\": \"12345678\", \"username\": \"studenthakan\" }";

        Response response = given()
                .body(body)
                .contentType(ContentType.JSON)
                .post("https://managementonschools.com/app/auth/login");
        //response.prettyPrint();
        return response.jsonPath().getString("token");
    }
    public static String generateTokenStudent2() {

        String body = "{ \"password\": \"12345678\", \"username\": \"AtabeyArzu\" }";

        Response response = given()
                .body(body)
                .contentType(ContentType.JSON)
                .post("https://managementonschools.com/app/auth/login");
        //response.prettyPrint();
        return response.jsonPath().getString("token");
    }



}