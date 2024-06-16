package com.lld.bms.dto;

import lombok.Data;

import java.util.List;
@Data
public class BookMovieRequestDTO {
    private List<Long> showSeatIds;
    private Long userId;
    private Long showId;


}
