package tests;

import org.junit.jupiter.api.Test;
import helpers.ObjectsPages;
import java.io.IOException;

public class CreateObjetos extends ObjectsPages {
    ObjectsPages ObjectsPages = new ObjectsPages();
    @Test
    public void CreateObjectsQazando() throws IOException {
        String jsonBody = ObjectsPages.readJson("src/test/java/data/createObjects.json");
        ObjectsPages.objectsPostResquest(jsonBody);

    }
    @Test
   public void FallCreate() throws IOException {
        String jsonBody = ObjectsPages.readJson("src/test/java/data/createObjects.json");
        ObjectsPages.objectsPostRequestFall(jsonBody);

    }
    @Test
    public void EmptyBody() throws IOException {
        ObjectsPages.objectsRequestEmptyBody();
    }
}
