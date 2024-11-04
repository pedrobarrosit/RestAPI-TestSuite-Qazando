package config;

import org.junit.jupiter.api.BeforeAll;
import  static io.restassured.RestAssured.*;

public class TestConfig {
    @BeforeAll
    public static void setup() {baseURI = System.getProperty("base.url","https://api.restful-api.dev");}
}
