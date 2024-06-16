package com.lld.bms.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Screen extends BaseModel{
    private String name;
    // 1: M
    // 1 : 1
    @OneToMany
    private List<Seat> seats;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection // Mapping table for enums screen_features
    private List<Feature> features;
}
