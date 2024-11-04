package pages;

import config.TestConfig;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class ObjectsPages extends TestConfig {

    public String readJson(String pathJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(pathJson)));
    }

    public void objectsPostResquest(String jsonBody) throws IOException {

        given()
                .contentType("application/json")
                .log().all()
                .body(jsonBody)
                .when()
                .post("/objects")
                .then()
                .log().all()
                .statusCode(200)
                .body("name",equalTo("Apple MacBook Pro 16"));
    }
    public void objectsPostRequestFall(String jsonBody) throws IOException {

        given()
                .contentType("application/json")
                .log().all()
                .body(jsonBody)
                .when()
                .post("/object")
                .then()
                .log().all()
                .statusCode(404)
                .body("error", equalTo("Not Found"));
    }
    public void objectsRequestEmptyBody() throws IOException {

        given()
                .contentType("application/json")
                .log().all()
                .body("")
                .when()
                .post("/objects")
                .then()
                .log().all()
                .statusCode(400)
                .body("error", equalTo("400 Bad Request. If you are trying to create or update the data, potential issue is that you are sending incorrect body json or it is missing at all."));
    }
    public void objectsGetRequestList() throws IOException {
        given()
                .contentType("application/json")
                .log().all()
                .when()
                .get("/objects")
                .then()
                .log().all()
                .statusCode(200)
                .body("id.size()", equalTo(13));
    }
    public void objectsGetRequestSearchIds() throws IOException {
        given()
                .contentType("application/json")
                .log().all()
                .when()
                .get("/objects?id=3&id=5&id=10")
                .then()
                .log().all()
                .statusCode(200)
                .body("id[0]", equalTo("3"))
                .body("id[1]", equalTo("5"))
                .body("id[2]", equalTo("10"));
    }
    public void objectsGetRequestNonExistent() throws IOException {
        given()
                .contentType("application/json")
                .log().all()
                .when()
                .get("/objects/19")
                .then()
                .log().all()
                .statusCode(404)
                .body("error", equalTo("Oject with id=19 was not found."));
    }
}
