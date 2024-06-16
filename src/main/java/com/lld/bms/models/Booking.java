package com.lld.bms.models;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Booking extends BaseModel{
    private BookingStatus bookingStatus;
    private List<ShowSeat> showSeats;
    private User user;
    private Date bookedAt;
    private Show show;
    private int amount;
    private List<Payment> payments;

}
