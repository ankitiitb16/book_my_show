package com.lld.bms.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Region extends BaseModel{
    private String name;
    // 1: M
    // 1 : 1
    @OneToMany
    private List<Theatre> theatres;
}
