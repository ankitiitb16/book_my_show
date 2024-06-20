package com.lld.bms.controllers;

import com.lld.bms.dto.BookMovieRequestDTO;
import com.lld.bms.dto.BookMovieResponseDTO;
import com.lld.bms.dto.ResponseStatus;
import com.lld.bms.models.Booking;
import com.lld.bms.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController {
    @Autowired // automatically find the object in params, create it if not created and pass it over
    private BookingService bookingService;

//    BookingController(BookingService bookingService){ // This is what autowires does
//        this.bookingService = bookingService;
//    }
    public BookMovieResponseDTO bookMovie(BookMovieRequestDTO bookMovieRequestDTO){
        BookMovieResponseDTO responseDTO = new BookMovieResponseDTO();

        try{
            Booking booking = bookingService.bookMovie(
                    bookMovieRequestDTO.getUserId(),
                    bookMovieRequestDTO.getShowSeatIds(),
                    bookMovieRequestDTO.getShowId()
            );
            responseDTO.setBookingId(booking.getId());
            responseDTO.setResponseStatus(ResponseStatus.SUCCESS);
            responseDTO.setAmount(booking.getAmount());
        } catch (Exception e){
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDTO;
    }
}
