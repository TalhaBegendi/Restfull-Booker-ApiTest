package apiClasses;

import BaseClass.BaseClass;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class patch_PartialUpdateBooking_200 extends post_CreateBooking_200 {

    public patch_PartialUpdateBooking_200(WebDriver driver)
    {

        super(driver);
    }
    public void patch_PartialUpdateBooking_Test(String jsonFile) throws IOException {

        post_CreateToken_200_Test("createToken");
        post_CreateBooking_200_Test("createBooking");

        RestAssured.baseURI="https://restful-booker.herokuapp.com/";

        JSONObject jsonObject = BaseClass.readJsonFile(jsonFile);

        Response response_PatchBooking = RestAssured.given()
                .contentType("application/json")
                .accept("application/json")
                .header("Cookie", "token="+token)
                .body(jsonObject.toString())
                .pathParam("id",bookingID)
                .when()
                .patch("booking/{id}")
                .then()
                .statusCode(200)
                .extract().response();

        System.out.println(response_PatchBooking.getBody().asString());
    }

}
