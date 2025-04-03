package org.example.tests.crud;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import org.example.asserts.AssertActions;
import org.example.bases.BaseTests;
import org.example.endpoints.APIConstants;
import org.example.pojos.Booking;
import org.example.pojos.BookingResponse;
import org.testng.annotations.Test;

public class UpdateBooking extends BaseTests {

    String token="0ee5678d3023ffe";
    @Owner("Saurabh tyagi")
    @Description("Verify update Booking")
    @TmsLink("www.xyz")
    @Test(priority = 3)
    public void test_updatebooking()
    {
        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING+"/"+765);
        requestSpecification.body(payloadManager.updateBookingPayload());
        requestSpecification.header("Cookie", "token=" + token);

        response=requestSpecification.when().put();

        validatableResponse = response.then().statusCode(200);
        validatableResponse.log().all();

        Booking updatebookingDetails = payloadManager.bookingResponsewithIDJava(response.asString());
        String updated_f_name=updatebookingDetails.getFirstname();
        System.out.println(updated_f_name);

        AssertActions.verifyResponse("Gaurav","Gaurav","Updated firstname");

    }

}
