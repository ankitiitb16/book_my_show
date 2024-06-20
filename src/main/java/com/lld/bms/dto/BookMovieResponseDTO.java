package com.lld.bms.dto;

import lombok.Data;

@Data
public class BookMovieResponseDTO {
    private ResponseStatus responseStatus;
    private Long bookingId;
    private int amount;
}
