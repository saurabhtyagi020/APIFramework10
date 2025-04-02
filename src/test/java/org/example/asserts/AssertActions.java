package org.example.asserts;

import static org.testng.Assert.assertEquals;

public class AssertActions {

    public static void verifyResponse(String actual,String expected,String description)
    {
       assertEquals(actual,expected,description);
    }
}
