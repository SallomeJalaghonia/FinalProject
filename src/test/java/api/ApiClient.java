package api;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class ApiClient {
    public static Response getUsers() {
        RestAssured.baseURI = "https://reqres.in/api";
        return given()
                .when()
                .get("/users?page=2")
                .then()
                .extract()
                .response();
    }
}
