package tests;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    @BeforeClass
    public void setup() {
        // Reads the value passed by Jenkins (-Denv=qa). Falls back to "dev" if nothing is passed.
        String env = System.getProperty("env", "dev");
        System.out.println("Running tests on environment: " + env);

        switch (env) {
            case "qa":
                RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
                break;
            case "staging":
                RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
                break;
            default:
                RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        }
    }
}