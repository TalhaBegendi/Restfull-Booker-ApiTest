import apiClasses.*;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class testClass {

    WebDriver Webdriver;
    @Test
    public void Create_Token()
    {
        post_CreateToken_200 createToken = new post_CreateToken_200(Webdriver);
        createToken.post_CreateToken_200_Test();
        createToken.post_CreateToken_200_Test1();
    }

    @Test
    public void Get_BookingID()
    {
        get_BookingID_200 getBookingID = new get_BookingID_200(Webdriver);
        getBookingID.get_BookingID_200_Test();
    }

    @Test
    public void Get_BookingDetails()
    {
        get_BookingDetails_200 getBookingDetails = new get_BookingDetails_200(Webdriver);
        getBookingDetails.get_BookingDetails_200_Test();
    }

    @Test
    public void Create_Booking()
    {
        post_CreateBooking_200 createBooking = new post_CreateBooking_200(Webdriver);
        createBooking.post_CreateBooking_200_Test();
        createBooking.post_CreateBooking_200_Test1();
    }

    @Test
    public void Update_Booking()
    {
        put_UpdateBooking_200 updateBooking = new put_UpdateBooking_200(Webdriver);
        updateBooking.put_UpdateBooking_200_Test();
    }

    @Test
    public void PartialUpdate_Booking()
    {
        patch_PartialUpdateBooking_200 patchBooking = new patch_PartialUpdateBooking_200(Webdriver);
        patchBooking.patch_PartialUpdateBooking_Test();
    }
    @Test
    public void Delete_Booking()
    {
        delete_DeleteBooking_200 deleteBooking = new delete_DeleteBooking_200(Webdriver);
        deleteBooking.delete_DeleteBooking_200_Test();
    }

}
