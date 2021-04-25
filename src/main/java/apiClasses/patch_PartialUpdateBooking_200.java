package apiClasses;

import booking_getSet.Booking;
import booking_getSet.PatchBooking;
import com.google.gson.Gson;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.openqa.selenium.WebDriver;
import tokenCreate_getSet.TokenCreate;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class patch_PartialUpdateBooking_200 extends post_CreateBooking_200 {

    public patch_PartialUpdateBooking_200(WebDriver driver)
    {
        super(driver);
    }
    public void patch_PartialUpdateBooking_Test(){

        post_CreateToken_200_Test();
        post_CreateBooking_200_Test();

        RestAssured.baseURI="https://restful-booker.herokuapp.com/";
        PatchBooking patchBooking = getPatchBookingGetSet();
        Gson gson = new Gson();
        String body = gson.toJson(patchBooking);

        Response response_PatchBooking = RestAssured.given()
                .contentType("application/json")
                .accept("application/json")
                .header("Cookie", "token="+token)
                .body(body)
                .pathParam("id",bookingID)
                .when()
                .patch("booking/{id}")
                .then()
                .statusCode(200)
                .extract().response();

        System.out.println(response_PatchBooking.getBody().asString());
    }

    private static PatchBooking getPatchBookingGetSet() {
        try {
            Gson gson = new Gson();
            FileReader reader;
            reader = new FileReader("src/test/talha/patchBooking.json");
            PatchBooking patchBookingGetSet = gson.fromJson(reader, PatchBooking.class);
            return patchBookingGetSet;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
