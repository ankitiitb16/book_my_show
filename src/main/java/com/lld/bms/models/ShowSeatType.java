package com.lld.bms.models;

import lombok.Data;

@Data
public class ShowSeatType extends BaseModel{
    private Show show;
    private SeatType seatType;
    private int price;
}
