package pages;

import config.TestConfig;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class updatePages extends TestConfig {

    public String readeJson(String objectJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(objectJson)));
}

    public void objectsPutRequestData(String jsonBody,String objectsId ) throws IOException {

        given()
                .contentType("application/json")
                .log().all()
                .body(jsonBody)
                .when()
                .put("/objects/"+ objectsId)
                .then()
                .log().all()
                .statusCode(200)
                .body("id", equalTo(objectsId));


    }
}
