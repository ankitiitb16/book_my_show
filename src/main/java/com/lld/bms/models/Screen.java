package com.lld.bms.models;

import lombok.Data;

import java.util.List;

@Data
public class Screen extends BaseModel{
    private String name;
    private List<Seat> seats;
    private List<Feature> features;
}
