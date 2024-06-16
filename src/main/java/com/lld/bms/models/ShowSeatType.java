package com.lld.bms.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class ShowSeatType extends BaseModel{
    // 1: 1
    // M: 1
    @ManyToOne
    private Show show;
    // 1: 1
    // M : 1
    @ManyToOne
    private SeatType seatType;
    private int price;
}
