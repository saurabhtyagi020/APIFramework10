package org.example.tests.crud;

import org.example.bases.BaseTests;
import org.example.endpoints.APIConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HealthCheck extends BaseTests {

    @Test
    public void test_health_check()
    {
        requestSpecification.basePath(APIConstants.PING_URL);

        response= requestSpecification.when().get();

        validatableResponse= response.then().statusCode(201);
        validatableResponse.log().all();

        Assert.assertEquals(201,response.getStatusCode());

        String responseString= response.getBody().asString();
        System.out.println("response: " +responseString);

        Assert.assertEquals("Created",responseString);


    }
}
