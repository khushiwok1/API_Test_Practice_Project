package tests;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostsApiTest {

    @Test
    public void getPostReturns200() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        given()
                .when().get("/posts/1")
                .then().statusCode(200)
                .body("id", equalTo(1));
    }

    @Test
    public void getUnknownPostReturns404() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        given()
                .when().get("/posts/99999")
                .then().statusCode(404);
    }
}