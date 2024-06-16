package com.lld.bms.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class BaseModel {
    private Long id;

    private Date dateCreated;

    private Date dateModified;
}
