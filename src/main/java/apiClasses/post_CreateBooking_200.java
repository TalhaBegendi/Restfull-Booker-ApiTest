package apiClasses;

import BaseClass.BaseClass;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;

import java.io.IOException;


public class post_CreateBooking_200 extends post_CreateToken_200 {
    //WebDriver  webDriver;
    Response response;
    String bookingID;

    public post_CreateBooking_200(WebDriver driver)
    {
        super(driver);
    }
    public  void post_CreateBooking_200_Test(String jsonFile) throws IOException {

        RestAssured.baseURI = "https://restful-booker.herokuapp.com/";

        JSONObject jsonObject = BaseClass.readJsonFile(jsonFile);

        response = RestAssured.given()

                .contentType("application/json")
                .body(jsonObject.toString())
                .when()
                .post("booking")
                .then()
                .statusCode(200)
                .extract().response();

        bookingID = response.path("bookingid").toString();
    }
    public  void post_CreateBooking_200_Test1()
    {
        System.out.println(response.asString());
    }
    }
