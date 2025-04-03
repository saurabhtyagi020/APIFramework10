package org.example.modules;

import com.google.gson.Gson;
import org.example.pojos.*;

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

    public Booking bookingResponsewithIDJava(String getbookingdetails)
    {
        gson = new Gson();
        Booking booking=gson.fromJson(getbookingdetails,Booking.class);
        return booking;
    }

    public String updateBookingPayload()
    {
        Booking booking = new Booking();
        booking.setFirstname("Gaurav");
        booking.setLastname("Kumar");
        booking.setDepositpaid(false);
        booking.setTotalprice(2000);

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2024-01-01");
        bookingdates.setCheckout("2025-01-01");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("lunch");

        gson = new Gson();
        String jsonupdatebooking = gson.toJson(booking);
        return jsonupdatebooking;
    }

    public BookingResponse updatedbookingresponse(String response)
    {
        gson = new Gson();
        BookingResponse bookingResponseString = gson.fromJson(response, BookingResponse.class);
        return bookingResponseString;
    }

    public String authPayload()
    {

        Auth auth = new Auth();
        auth.setUsername("admin");
        auth.setPassword("password123");

        gson= new Gson();
        String jsontokenpayload = gson.toJson(auth);
        return jsontokenpayload;

    }

    public String getTokeneResponse(String tokenresponse)
    {
        gson = new Gson();
        AuthResponse tokenresponseAsstring = gson.fromJson(tokenresponse, AuthResponse.class);
        return tokenresponseAsstring.getToken();
    }



}

