package apiClasses;

import java.io.FileNotFoundException;
import java.io.FileReader;
import com.google.gson.Gson;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.openqa.selenium.WebDriver;
import booking_getSet.Booking;

public class put_UpdateBooking_200 extends post_CreateBooking_200   {

    public put_UpdateBooking_200(WebDriver driver)
    {

        super(driver);
    }

    public void put_UpdateBooking_200_Test(){

        post_CreateToken_200_Test();
        post_CreateBooking_200_Test();

        RestAssured.baseURI="https://restful-booker.herokuapp.com/";

        Booking updateBookingGetSet = getUpdateBookingGetSet();
        Gson gson = new Gson();
        String body = gson.toJson(updateBookingGetSet);

        Response response_UpdateBooking = RestAssured.given()
                .contentType("application/json")
                .accept("application/json")
                .header("Cookie", "token="+token)
                .body(body)
                .pathParam("id",bookingID)
                .when()
                .put("booking/{id}")
                .then()
                .statusCode(200)
                .extract().response();

        System.out.println(response_UpdateBooking.getBody().asString());
    }
    private static Booking getUpdateBookingGetSet() {
        try {
            Gson gson = new Gson();
            FileReader reader;
            reader = new FileReader("src/test/talha/updateBooking.json");
            Booking updateBookingGetSet = gson.fromJson(reader, Booking.class);
            return updateBookingGetSet;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}