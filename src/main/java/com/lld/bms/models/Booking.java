package com.lld.bms.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class Booking extends BaseModel{
    @Enumerated(EnumType.ORDINAL)
    private BookingStatus bookingStatus;
    // B: S
    // 1: M
    // M: 1 in case of cancelled one
    // M: M
    @ManyToMany
    private List<ShowSeat> showSeats;

    // 1 user can have multiple bookings
    @ManyToOne
    private User user;
    private Date bookedAt;
    @ManyToOne
    private Show show;

    private int amount;
    // 1: M
    // 1 : 1
    @OneToMany
    private List<Payment> payments;

}
