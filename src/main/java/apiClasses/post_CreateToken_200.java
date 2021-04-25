package apiClasses;

import BaseClass.BaseClass;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;

import java.io.IOException;


public class post_CreateToken_200 extends BaseClass {
    String token;
    Response response;

    public post_CreateToken_200(WebDriver driver)
    {
        super(driver);
    }
    public  void post_CreateToken_200_Test(String jsonFile) throws IOException {

        RestAssured.baseURI="https://restful-booker.herokuapp.com/";

        JSONObject jsonObject = BaseClass.readJsonFile(jsonFile);

        response = RestAssured.given()

         .contentType("application/json")
         .body(jsonObject.toString())
         .when()
         .post("auth")
         .then()
        .statusCode(200)
        .extract().response();

        token = response.path("token").toString();
    }
    public  void post_CreateToken_200_Test1() {
        System.out.println(response.asString());
    }
}