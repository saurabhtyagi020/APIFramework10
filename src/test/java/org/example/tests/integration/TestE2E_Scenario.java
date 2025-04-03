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
import org.testng.annotations.Test;

public class TestE2E_Scenario extends BaseTests {


    @Owner("Saurabh tyagi")
    @Description("Verify create booking")
    @TmsLink("www.xyz")
    @Test(priority = 1)
    public void testCreateBooking()
    {
        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING);
        requestSpecification.body(payloadManager.createPayload());

        response = requestSpecification.when().post();

        validatableResponse = response.then().statusCode(200);
        validatableResponse.log().all();

        BookingResponse bookingresponse = payloadManager.bookingResponseJava(response.asString());
        String fName= bookingresponse.getBooking().getLastname();
        Integer bId = bookingresponse.getBookingid();
        System.out.println(fName);
        System.out.println(bId);

        Assert.assertEquals(200,response.getStatusCode());
        Assert.assertEquals(fName,"Gaurav");
        AssertActions.verifyResponse("Gaurav","Gaurav","Bookingfirstname");









    }
}
