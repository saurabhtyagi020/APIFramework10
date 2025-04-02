package org.example.modules;

import com.google.gson.Gson;
import org.example.pojos.Booking;
import org.example.pojos.BookingResponse;
import org.example.pojos.Bookingdates;

public class PayloadManager {

    Gson gson;
    public String createPayload()
    {
        Booking booking = new Booking();
        booking.setFirstname("Raja");
        booking.setLastname("Ram");
        booking.setDepositpaid(true);
        booking.setTotalprice(1000);

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2020-01-01");
        bookingdates.setCheckout("2021-01-01");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");

        gson = new Gson();
        String jsonbookindstring=gson.toJson(booking);
        return jsonbookindstring;

    }

    public BookingResponse bookingResponseJava(String responseString)
    {
        gson = new Gson();
        BookingResponse bookingResponse=gson.fromJson(responseString,BookingResponse.class);
        return bookingResponse;
    }
}

