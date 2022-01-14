package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class GreetingResourceTest {

    @Test
    public void testProperties() {
        //Test default static value is injected properly
        given()
                .when().get("/hello")
                .then()
                .statusCode(200)
                .body(is("Hello User!!"));
        //change property value
        given().body("new greeting message")
                .when().post("/hello")
                .then()
                .statusCode(200)
                .body(is("Hello User!!"));

        //check new property value is set
        given()
                .when().get("/hello")
                .then()
                .statusCode(200)
                .body(is("new greeting message"));
    }

}