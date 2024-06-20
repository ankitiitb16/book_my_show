package com.lld.bms.services;

import com.lld.bms.models.Show;
import com.lld.bms.models.ShowSeat;
import com.lld.bms.models.ShowSeatType;
import com.lld.bms.repositories.ShowSeatTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PriceCalculator {

    @Autowired
    ShowSeatTypeRepository showSeatTypeRepository;
    public int calculatePrice(List<ShowSeat> showSeats, Show show){
        // 1. find out type of seats in the given show
        // 2. get seattype for all teh slected seats
        // 3. calculate amount
        List<ShowSeatType> showSeatTypes = showSeatTypeRepository.findAllByShow(show);
        int amount = 0;
        for (ShowSeat showSeat: showSeats){
            for (ShowSeatType showSeatType: showSeatTypes){
                if(showSeat.getSeat().getSeatType().equals(showSeatType.getSeatType())){
                    amount += showSeatType.getPrice();
                }
            }
        }
        return amount;
    }
}
