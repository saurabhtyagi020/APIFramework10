package org.example.tests.crud;

import org.example.bases.BaseTests;
import org.example.endpoints.APIConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteBooking extends BaseTests {

    String token="086a031ac70a9d7";
    @Test
    public void test_delete_booking()
    {
        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING+"/"+1716);
        requestSpecification.cookie("token",token);

        response=requestSpecification.when().delete();

        validatableResponse= response.then().statusCode(201);

        Assert.assertEquals(201,response.getStatusCode());
        String responseString=response.getBody().asString();
        System.out.println(responseString);
        Assert.assertEquals("Created",responseString);


    }

}
