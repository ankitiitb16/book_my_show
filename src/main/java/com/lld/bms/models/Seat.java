package com.lld.bms.models;

import lombok.Data;

@Data
public class Seat extends BaseModel{
    private String seatNumber;
    private SeatType seatType;
    private int rowVal;
    private int colVal;
}
