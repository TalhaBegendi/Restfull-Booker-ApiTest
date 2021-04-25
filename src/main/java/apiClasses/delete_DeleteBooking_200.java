package apiClasses;


import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.openqa.selenium.WebDriver;

public class delete_DeleteBooking_200 extends post_CreateBooking_200 {

    public delete_DeleteBooking_200(WebDriver driver) {

        super(driver);
    }

    public void delete_DeleteBooking_200_Test(){

        post_CreateToken_200_Test();
        post_CreateBooking_200_Test();

        RestAssured.baseURI="https://restful-booker.herokuapp.com/";

        Response response_UpdateBooking = RestAssured.given()
                .contentType("application/json")
                .accept("application/json")
                .header("Cookie", "token="+token)
                .pathParam("id",bookingID)
                .when()
                .delete("booking/{id}")
                .then()
                .statusCode(201)
                .extract().response();

        System.out.println(response_UpdateBooking.getBody().asString());

    }
}
