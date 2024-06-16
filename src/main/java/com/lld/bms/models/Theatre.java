package com.lld.bms.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Theatre extends BaseModel{
    private String name;
    // 1 Thatre: 1 Region
    // M Theatres: 1 Region
    @ManyToOne
    private Region region;
    // 1: M
    // 1 Theatre : 1 Screen
    @OneToMany
    private List<Screen> screens;
}
