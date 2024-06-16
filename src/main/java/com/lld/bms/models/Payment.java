package com.lld.bms.models;

import lombok.Data;

@Data
public class Payment extends BaseModel{
    private String refNo;
    private int amount;
//    private Booking booking;
    private PaymentStatus paymentStatus;
    private PaymentProvider paymentProvider;
}
