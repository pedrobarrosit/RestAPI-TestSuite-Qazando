package tests;

import config.TestConfig;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;


public class ChangeData extends TestConfig {

    public String changeObjects(String objectJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(objectJson)));

    }
    @Test
    public void changeDatas() throws IOException {
        String jsonBody = changeObjects("src/test/java/data/changeData.json");
        given()
                .contentType("application/json")
                .log().all()
                .body(jsonBody)
                .when()
                .put("/objects/ff80818192925da70192d59fdcdf1555")
                .then()
                .log().all()
                .statusCode(200)
                .body("id", equalTo("ff80818192925da70192d59fdcdf1555"));
    }
    @Test
    public void changeName() throws IOException {
        String updatedName = "Apple MacBook Pro 16 (Updated Name)";
        String requestBody = "{\"name\": \"" + updatedName + "\"}";
        given()
                .contentType("application/json")
                .log().all()
                .body(requestBody)
                .when()
                .patch("/objects/ff80818192925da70192d7c8f39d1cb1")
                .then()
                .statusCode(200)
                .body("name", equalTo("Apple MacBook Pro 16 (Updated Name)"));
    }
    @Test
    public void changeModel() throws IOException {
        String updatedCpuModel = "Intel Core i10";
        String requestBody = "{\"data\":{\"CPU model\": \"" + updatedCpuModel + "\"}}";
        given()
                .contentType("application/json")
                .log().all()
                .body(requestBody)
                .when()
                .patch("/objects/ff80818192925da70192d7c8f39d1cb1")
                .then()
                .statusCode(200)
                .body("name", equalTo("Apple MacBook Pro 16 (Updated Name)"));
    }
}
