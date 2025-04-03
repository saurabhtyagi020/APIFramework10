package org.example.tests.crud;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import io.restassured.RestAssured;
import org.example.bases.BaseTests;
import org.example.endpoints.APIConstants;
import org.example.pojos.Booking;
import org.example.pojos.BookingResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GETBookingWithId extends BaseTests {

    String bookingID="";
    @Owner("Saurabh tyagi")
    @Description("Verify Booking id")
    @TmsLink("www.xyz")
    @Test(priority = 2)
    public void test_getfromBookingId()
    {
        requestSpecification.basePath("/booking/20");

        response=requestSpecification.when().get();

        validatableResponse=response.then().statusCode(200);

        Assert.assertEquals(200,response.getStatusCode());
        Booking bookingDetails = payloadManager.bookingResponsewithIDJava(response.asString());
        System.out.println("---------------------------");
        System.out.println("firstName: "+bookingDetails.getFirstname());
        System.out.println("lastName: "+bookingDetails.getLastname());

    }
}
