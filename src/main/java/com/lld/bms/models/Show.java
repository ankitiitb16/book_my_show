package com.lld.bms.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity(name = "shows")
public class Show extends BaseModel{
    // 1: 1
    // M:1
    @ManyToOne
    private Movie movie;
    private Date startTime;
    private Date endTime;
    // 1: 1
    // M:1
    @ManyToOne
    private Screen screen;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> features;
}
