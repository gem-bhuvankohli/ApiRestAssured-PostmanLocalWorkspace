import io.restassured.response.Response;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import java.util.HashMap;
public class PostmanApiTest {
    static String workspaceID;


    @Test
    public static void getMethod() {
        try {
            Response res = RestUtils.getAPI("/workspaces");
            res.prettyPrint();
        } catch (Exception e) {

        }
    }

    @Test
    public static void postMethod() {
        HashMap<String, Object> payload = new HashMap<>();
        HashMap<String,Object>innerPayload = new HashMap<>();
        innerPayload.put("name","kohli");
        innerPayload.put("type","personal");
        innerPayload.put("description","personal workspace");
        payload.put("workspace",innerPayload);

        try {
            Response res = RestUtils.postAPI("/workspaces",payload);
            res.prettyPrint();
           String str = res.prettyPrint().split(":")[2].split(",")[0];
           workspaceID = str.substring(2,str.length()-1);
        } catch (Exception e) {

        }
    }

    @Test
    public static void putMethod() {
        HashMap<String, Object> payload = new HashMap<>();
        HashMap<String,Object>innerPayload = new HashMap<>();
        innerPayload.put("name","bhuvan");
        innerPayload.put("type","personal");
        innerPayload.put("description","personal workspace");

        payload.put("workspace",innerPayload);

        try {
            Response res = RestUtils.putAPI("/workspaces",workspaceID,payload);
            res.prettyPrint();
        } catch (Exception e) {

        }
    }

    @AfterTest
    public static void delMethod() {
        try {
            Response res = RestUtils.deleteAPI("/workspaces",workspaceID);
            res.prettyPrint();
        } catch (Exception e) {

        }
    }

}