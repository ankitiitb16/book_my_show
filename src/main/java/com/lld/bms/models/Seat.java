package com.lld.bms.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Seat extends BaseModel{
    private String seatNumber;
    // 1: 1
    // M : 1
    @ManyToOne
    private SeatType seatType;
    private int rowVal;
    private int colVal;
}
