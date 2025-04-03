package org.example.tests.integration;

import com.google.gson.Gson;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import org.example.asserts.AssertActions;
import org.example.bases.BaseTests;
import org.example.endpoints.APIConstants;
import org.example.pojos.Booking;
import org.example.pojos.BookingResponse;
import org.example.pojos.Bookingdates;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class TestE2E_Scenario extends BaseTests {


    @Owner("Saurabh tyagi")
    @Description("Verify create booking")
    @TmsLink("www.xyz")
    @Test(priority = 1)
    public void testCreateBooking(ITestContext iTestContext)
    {
        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING);
        requestSpecification.body(payloadManager.createPayload());

        response = requestSpecification.when().post();

        validatableResponse = response.then().statusCode(200);
        validatableResponse.log().all();

        BookingResponse bookingresponse = payloadManager.bookingResponseJava(response.asString());
        String fName= bookingresponse.getBooking().getFirstname();
        Integer bId = bookingresponse.getBookingid();
        System.out.println(fName);
        System.out.println(bId);

        Assert.assertEquals(200,response.getStatusCode());
        Assert.assertEquals(fName,"Raja");
        AssertActions.verifyResponse("Raja","Raja","Bookingfirstname");

        iTestContext.setAttribute("bookingId",bookingresponse.getBookingid());

    }

    @Owner("Saurabh tyagi")
    @Description("Verify Booking id")
    @TmsLink("www.xyz")
    @Test(priority = 2)
    public void testverifyBookingId(ITestContext iTestContext)
    {
        Integer bookingid = (Integer) iTestContext.getAttribute("bookingId");

        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING+"/"+bookingid);

        response = requestSpecification.when().get();

        validatableResponse =response.then().statusCode(200);
        Assert.assertEquals(200,response.getStatusCode());

        Booking booking = payloadManager.bookingResponsewithIDJava(response.asString());
        System.out.println(booking.getFirstname());

    }


    @Owner("Saurabh tyagi")
    @Description("Verify update Booking")
    @TmsLink("www.xyz")
    @Test(priority = 3)
    public void testupdateBooking(ITestContext iTestContext)
    {
        Integer bookingid=(Integer) iTestContext.getAttribute("bookingId");
        String token = getToken();
        iTestContext.setAttribute("token",token);
       requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING+"/"+bookingid);
       requestSpecification.cookie("token",token);
       requestSpecification.body(payloadManager.updateBookingPayload());

       response=requestSpecification.when().put();

       validatableResponse=response.then().statusCode(200);
       validatableResponse.log().all();

        Booking updatebookingDetails = payloadManager.bookingResponsewithIDJava(response.asString());
        String updated_f_name=updatebookingDetails.getFirstname();
        System.out.println(updated_f_name);

        AssertActions.verifyResponse("Gaurav","Gaurav","Updated firstname");

    }

    @Owner("Saurabh tyagi")
    @Description("Verify Delete Booking")
    @TmsLink("www.xyz")
    @Test(priority = 4)
    public void testdeleteBooking(ITestContext iTestContext)
    {
        Integer bookingid=(Integer) iTestContext.getAttribute("bookingId");
        String token = getToken();
        iTestContext.setAttribute("token",token);
        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING+"/"+bookingid);
        requestSpecification.cookie("token",token);

        response = requestSpecification.when().delete();

        validatableResponse = response.then().statusCode(201);

        Assert.assertEquals(201,response.getStatusCode());

        String responseString = response.getBody().asString();
        System.out.println(responseString);

        Assert.assertEquals("Created",responseString);
    }

}
