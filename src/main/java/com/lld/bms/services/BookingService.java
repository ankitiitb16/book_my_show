package com.lld.bms.services;

import com.lld.bms.models.Booking;
import com.lld.bms.models.User;
import com.lld.bms.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    @Autowired
    private UserRepository userRepository;
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking bookMovie(Long userId, List<Long> showSeatId, Long showId){
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


        return null;
    }
}
