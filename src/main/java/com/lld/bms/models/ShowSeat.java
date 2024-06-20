package com.lld.bms.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class ShowSeat extends BaseModel{
    // sid seatId status
    // 1   x      Booked
    // 1   y      Booked
    // 1: 1
    // m : 1 show
    @ManyToOne
    private Show show;
    // 1: 1
    // M: 1
    @ManyToOne
    private Seat seat;

    @Enumerated(EnumType.ORDINAL)
    private ShowSeatStatus showSeatStatus;
    private Date lockedAt;
}
