package apiClasses;

import org.openqa.selenium.WebDriver;
import java.io.FileNotFoundException;
import java.io.FileReader;
import tokenCreate_getSet.TokenCreate;
import com.google.gson.Gson;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;


public class post_CreateToken_200 {
    WebDriver  webDriver;
    String token;
    Response response;

    public post_CreateToken_200(WebDriver driver)
    {

        this.webDriver = driver;
    }
    public  void post_CreateToken_200_Test(){

        RestAssured.baseURI="https://restful-booker.herokuapp.com/";
        TokenCreate tokenCreateGetSet = tokenCreate();
        Gson gson = new Gson();
        String body = gson.toJson(tokenCreateGetSet);

        response = RestAssured.given()

         .contentType("application/json")
         .body(body)
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
    private static TokenCreate tokenCreate() {
        try {
            Gson gson = new Gson();
            FileReader reader;
            reader = new FileReader("src/test/talha/createToken.json");
            TokenCreate tokenCreateGetSet = gson.fromJson(reader, TokenCreate.class);
            return tokenCreateGetSet;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }



}