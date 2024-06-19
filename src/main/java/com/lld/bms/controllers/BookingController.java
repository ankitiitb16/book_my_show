package com.lld.bms.controllers;

import com.lld.bms.dto.BookMovieRequestDTO;
import com.lld.bms.dto.BookMovieResponseDTO;
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

        return null;
    }
}
