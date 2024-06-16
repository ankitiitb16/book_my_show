package com.lld.bms.models;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Show extends BaseModel{
    private Movie movie;
    private Date startTime;
    private Date endTime;
    private Screen screen;
    private List<Feature> features;
}
