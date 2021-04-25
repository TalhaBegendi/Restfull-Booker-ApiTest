import apiClasses.*;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class testClass {

    WebDriver Webdriver;
    @Test
    public void a_Create_Token() throws IOException {
        post_CreateToken_200 createToken = new post_CreateToken_200(Webdriver);
        createToken.post_CreateToken_200_Test("createToken");
        createToken.post_CreateToken_200_Test1();
    }
    @Test
    public void b_Get_BookingID()
    {
        get_BookingID_200 getBookingID = new get_BookingID_200(Webdriver);
        getBookingID.get_BookingID_200_Test();
    }
    @Test
    public void c_Get_BookingDetails()
    {
        get_BookingDetails_200 getBookingDetails = new get_BookingDetails_200(Webdriver);
        getBookingDetails.get_BookingDetails_200_Test();
    }
    @Test
    public void d_Create_Booking() throws IOException {
        post_CreateBooking_200 createBooking = new post_CreateBooking_200(Webdriver);
        createBooking.post_CreateBooking_200_Test("createBooking");
        createBooking.post_CreateBooking_200_Test1();
    }
    @Test
    public void e_Update_Booking() throws IOException {
        put_UpdateBooking_200 updateBooking = new put_UpdateBooking_200(Webdriver);
        updateBooking.put_UpdateBooking_200_Test("updateBooking");
    }
    @Test
    public void f_PartialUpdate_Booking() throws IOException {
        patch_PartialUpdateBooking_200 patchBooking = new patch_PartialUpdateBooking_200(Webdriver);
        patchBooking.patch_PartialUpdateBooking_Test("updateBooking");
    }
    @Test
    public void g_Delete_Booking() throws IOException {
        delete_DeleteBooking_200 deleteBooking = new delete_DeleteBooking_200(Webdriver);
        deleteBooking.delete_DeleteBooking_200_Test();
    }
}
