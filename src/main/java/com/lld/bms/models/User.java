package com.lld.bms.models;

import lombok.Data;

import java.util.List;

@Data
public class User extends BaseModel{
    private String name;
    private String email;
    private List<Booking> bookings;
}
