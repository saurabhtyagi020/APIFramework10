package org.example.tests.crud;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import io.restassured.RestAssured;
import org.example.asserts.AssertActions;
import org.example.bases.BaseTests;
import org.example.endpoints.APIConstants;
import org.example.pojos.BookingResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateBooking extends BaseTests
{
    @Owner("Saurabh tyagi")
    @Description("Verify create booking")
    @TmsLink("www.xyz")
    @Test(priority = 1)
    public void testCreateBooking()
    {
        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING);
        requestSpecification.body(payloadManager.createPayload());

        response= requestSpecification.when().post();

        validatableResponse =response.then().statusCode(200);
        validatableResponse.log().all();

        Assert.assertEquals(200,response.getStatusCode());

        BookingResponse bookingresponse = payloadManager.bookingResponseJava(response.asString());
        AssertActions.verifyResponse(bookingresponse.getBooking().getFirstname(),"Raja","Createbooking fisrtname");


    }
}
