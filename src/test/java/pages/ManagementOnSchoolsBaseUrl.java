package pages;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static utilities.Authentication.*;
import static utilities.ManagementOnSchoolAuthorization.generateToken;

public class ManagementOnSchoolsBaseUrl {
public static RequestSpecification spec;

    public static void setUpAdmin() {

        spec = new RequestSpecBuilder()
                .addHeader("Authorization", generateToken())
                .setBaseUri("https://managementonschools.com/app")
                .setContentType(ContentType.JSON)
                .build();
    }

    public static void setUpDean() {

        spec = new RequestSpecBuilder()
                .addHeader("Authorization", generateTokenDean())
                .setBaseUri("https://managementonschools.com/app")
                .setContentType(ContentType.JSON)
                .build();
    }

    public static void setUpViceDean() {

        spec = new RequestSpecBuilder()
                .addHeader("Authorization", generateTokenViceDean())
                .setBaseUri("https://managementonschools.com/app")
                .setContentType(ContentType.JSON)
                .build();
    }

    public static void setUpTeacher() {

        spec = new RequestSpecBuilder()
                .addHeader("Authorization", generateTokenTeacher())
                .setBaseUri("https://managementonschools.com/app")
                .setContentType(ContentType.JSON)
                .build();
    }

    public static void setUpTeacher2() {

        spec = new RequestSpecBuilder()
                .addHeader("Authorization", generateTokenTeacher2())
                .setBaseUri("https://managementonschools.com/app")
                .setContentType(ContentType.JSON)
                .build();
    }

    public static void setUpStudent() {

        spec = new RequestSpecBuilder()
                .addHeader("Authorization", generateTokenStudent())
                .setBaseUri("https://managementonschools.com/app")
                .setContentType(ContentType.JSON)
                .build();
    }

    public static void setUpStudent2() {

        spec = new RequestSpecBuilder()
                .addHeader("Authorization", generateTokenStudent2())
                .setBaseUri("https://managementonschools.com/app")
                .setContentType(ContentType.JSON)
                .build();
    }


}