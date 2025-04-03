package org.example.bases;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.http.ContentType;
import org.example.asserts.AssertActions;
import org.example.endpoints.APIConstants;
import org.example.modules.PayloadManager;
import org.testng.annotations.BeforeTest;

public class BaseTests {

   public RequestSpecification requestSpecification;
   public Response response;
   public ValidatableResponse validatableResponse;
   public PayloadManager payloadManager ;
   public AssertActions assertActions;

    @BeforeTest
    public void setup()
    {

        payloadManager = new PayloadManager();
        assertActions = new AssertActions();

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri(APIConstants.BASE_URL);
        requestSpecification.contentType(ContentType.JSON).log().all();

//        requestSpecification = new RequestSpecBuilder()
//                .setBaseUri(APIConstants.BASE_URL)
//                .addHeader("Content-Type", "application/json")
//                .build().log().all();

    }

        public String getToken()
        {
            requestSpecification=RestAssured.given().baseUri(APIConstants.BASE_URL)
                    .basePath(APIConstants.AUTH_URL);
            requestSpecification.body(payloadManager.authPayload());
            requestSpecification.contentType(ContentType.JSON);

            response=requestSpecification.when().post();

            validatableResponse =response.then().statusCode(200);
            validatableResponse.log().all();

            String token = payloadManager.getTokeneResponse(response.asString());
            return token;


        }
}
