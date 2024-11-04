package tests;

import org.junit.jupiter.api.Test;
import pages.ObjectsPages;
import java.io.IOException;


public class ObjectSearch extends ObjectsPages {
    ObjectsPages ObjectsPages = new ObjectsPages();
    @Test
    public void listaObjects() throws IOException {
        ObjectsPages.objectsGetRequestList();
    }
    @Test
    public void ObjectsSearchIds() throws IOException {
        ObjectsPages.objectsGetRequestSearchIds();
    }
    @Test
    public void nonExistentObject() throws IOException {
        ObjectsPages.objectsGetRequestNonExistent();
    }
}
