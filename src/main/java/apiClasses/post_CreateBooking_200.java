package apiClasses;

import booking_getSet.Booking;
import org.openqa.selenium.WebDriver;
import java.io.FileNotFoundException;
import java.io.FileReader;
import com.google.gson.Gson;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;


public class post_CreateBooking_200 extends post_CreateToken_200 {
    //WebDriver  webDriver;
    Response response;
    String bookingID;

    public post_CreateBooking_200(WebDriver driver)
    {
        super(driver);
    }
    public  void post_CreateBooking_200_Test() {

        RestAssured.baseURI = "https://restful-booker.herokuapp.com/";

        Booking createBookingGetSet = getCreateBookingGetSet();
        Gson gson = new Gson();
        String body = gson.toJson(createBookingGetSet);

        response = RestAssured.given()

                .contentType("application/json")
                .body(body)
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

    private static Booking getCreateBookingGetSet() {
        try {
            Gson gson = new Gson();
            FileReader reader;
            reader = new FileReader("src/test/talha/createBooking.json");
            Booking createBookingGetSet = gson.fromJson(reader, Booking.class);
            return createBookingGetSet;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    }
