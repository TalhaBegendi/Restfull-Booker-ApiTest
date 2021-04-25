package apiClasses;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.openqa.selenium.WebDriver;

public class get_BookingDetails_200 {
    WebDriver webDriver;
    Response response;

    public get_BookingDetails_200(WebDriver driver)
    {
        this.webDriver = driver;
    }
    public  void get_BookingDetails_200_Test() {

        RestAssured.baseURI = "https://restful-booker.herokuapp.com/";
        response = RestAssured.given()
                .contentType("application/json")
                .when()
                .get("booking/1")
                .then()
                .statusCode(200)
                .extract().response();

        System.out.println(response.asString());
    }
}
