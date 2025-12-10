package com.scaler.BookMyShowSeptEve.Services;

import com.scaler.BookMyShowSeptEve.Exceptions.InvalidShowException;
import com.scaler.BookMyShowSeptEve.Exceptions.InvalidUserException;
import com.scaler.BookMyShowSeptEve.Models.Booking;
import com.scaler.BookMyShowSeptEve.Models.Show;
import com.scaler.BookMyShowSeptEve.Models.User;
import com.scaler.BookMyShowSeptEve.Repositories.ShowRepository;
import com.scaler.BookMyShowSeptEve.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    @Autowired
    UserRepository userRepository;
    ShowRepository showRepository;


    public Booking bookTicket(Long userId, Long showId, List<Long> showSeatIds) throws InvalidUserException, InvalidShowException {
        // *****Ticket booking logic******
        // 1. Fetch user from userId and check user exists
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isEmpty()){
            throw new InvalidUserException("Invalid user");
        }
        // 2. Fetch show from showId and check show validity
        Optional<Show> showOptional = showRepository.findById(showId);
        if(showOptional.isEmpty()){
            throw new InvalidShowException("Invalid show");
        }
        // ----------Take lock-----------
        // 3. Fetch all the showSeats from showSeatIds and validate them
        // 4. Loop through all showSeats and check their availability
        // 5. Change the status of the showSeats to blocked
        // ----------Release Lock----------
        // 6. Create a booking with the showSeats and other data
        // 7. Finally return the booking
        return new Booking();
    }
    //bookTicket(Long userId, Long showId, List<Long> showSeatIds, List<Long> foodItemIds)
    // bookTicket(requestDTO)
    // if(requestDTO.getFoodItemIds() != null)
}

