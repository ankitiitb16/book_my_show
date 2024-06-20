package com.lld.bms.services;

import com.lld.bms.models.*;
import com.lld.bms.repositories.BookingRepository;
import com.lld.bms.repositories.ShowRepository;
import com.lld.bms.repositories.ShowSeatRepository;
import com.lld.bms.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    ShowRepository showRepository;

    @Autowired
    ShowSeatRepository showSeatRepository;

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    PriceCalculator priceCalculator;

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking bookMovie(Long userId, List<Long> showSeatIds, Long showId){
        // 1. get the user by user id
        // 2. get the show with the show id
        // ------- Take lock ---------(start txn)
        // 3. get the showSeat using seatIds
        // 4. check if all the seats are available
        // 5. if no, throw error
        // 6. if yes, mark all of the selected seats as BLOCKED
        // 7. save it in the database
        // -------Release the lock-------(end txn)
        // 8. create the corresponding Booking object
        // 9. save the booking detains in the database
        // 10. return the booking object
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isEmpty()){
            throw new RuntimeException("No such User found");
        }
        User bookedBy = userOptional.get();
        Optional<Show> showOptional = showRepository.findById(showId);
        if(showOptional.isEmpty()){
            throw new RuntimeException("No such show found");
        }
        Show bookedShow = showOptional.get();
        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIds);
        /*
        why not optional of list because list can be empty
         */
        for (ShowSeat showSeat: showSeats){
            if(!showSeat.getShowSeatStatus().equals( ShowSeatStatus.AVAILABLE)  &&
                    (showSeat.getShowSeatStatus().equals(ShowSeatStatus.BLOCKED) &&
                            Duration.between(showSeat.getLockedAt().toInstant(), new Date().toInstant()).toMinutes() < 15)
                    ) {
                throw new RuntimeException("Selected seats are not available");
            }
            showSeat.setShowSeatStatus(ShowSeatStatus.BLOCKED);
            showSeat.setLockedAt(new Date());
        }
        List<ShowSeat> savedShowSeats = showSeatRepository.saveAll(showSeats);
        Booking booking = new Booking();
        booking.setBookingStatus(BookingStatus.PENDING);
        booking.setShowSeats(savedShowSeats);
        booking.setUser(bookedBy);
        booking.setBookedAt(new Date());
        booking.setShow(bookedShow);
        booking.setPayments(new ArrayList<>());
        booking.setAmount(priceCalculator.calculatePrice(savedShowSeats, bookedShow));
        booking = bookingRepository.save(booking);
        return booking;
    }
}
