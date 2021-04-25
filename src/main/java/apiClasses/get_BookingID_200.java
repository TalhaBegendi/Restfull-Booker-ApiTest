package apiClasses;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.openqa.selenium.WebDriver;

public class get_BookingID_200 {
    WebDriver webDriver;
    Response response;

    public get_BookingID_200(WebDriver driver)
    {

        this.webDriver = driver;
    }
    public  void get_BookingID_200_Test() {

        RestAssured.baseURI = "https://restful-booker.herokuapp.com/";
        response = RestAssured.given()
                .when()
                .get("booking")
                .then()
                .statusCode(200)
                .extract().response();

        System.out.println(response.asString());
    }
}
