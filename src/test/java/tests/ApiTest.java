package tests;
import api.ApiClient;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApiTest {
    @Test
    public void testGetUsersStatusCode() {
        Response response = ApiClient.getUsers();
        Assert.assertEquals(response.getStatusCode(), 200, "სტატუს კოდი არასწორია!");
    }
}
