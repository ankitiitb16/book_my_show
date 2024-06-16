package com.lld.bms.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class User extends BaseModel{
    private String name;
    private String email;
    // 1 User: M bookings ,
    // 1 Booking: 1 user
    @OneToMany
    private List<Booking> bookings;
}
