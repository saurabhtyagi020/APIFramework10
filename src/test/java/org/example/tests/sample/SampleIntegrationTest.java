package org.example.tests.sample;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleIntegrationTest {

    @Owner("Saurabh tyagi")
    @Description("Verify create booking")
    @TmsLink("www.xyz")
    @Test(priority = 1)
    public void testCreateBooking()
    {
        Assert.assertTrue(true);
    }

    @Owner("Saurabh tyagi")
    @Description("Verify Booking id")
    @TmsLink("www.xyz")
    @Test(priority = 2)
    public void testverifyBookingId()
    {
        Assert.assertTrue(true);
    }

    @Owner("Saurabh tyagi")
    @Description("Verify update Booking")
    @TmsLink("www.xyz")
    @Test(priority = 3)
    public void testupdateBooking()
    {
        Assert.assertTrue(true);
    }

    @Owner("Saurabh tyagi")
    @Description("Verify Delete Booking")
    @TmsLink("www.xyz")
    @Test(priority = 4)
    public void testdeleteBooking()
    {
        Assert.assertTrue(true);
    }



}
