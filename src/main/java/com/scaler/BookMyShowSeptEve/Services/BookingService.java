package com.scaler.BookMyShowSeptEve.Services;

import com.scaler.BookMyShowSeptEve.Exceptions.InputValidationException;
import com.scaler.BookMyShowSeptEve.Exceptions.InvalidShowException;
import com.scaler.BookMyShowSeptEve.Exceptions.InvalidUserException;
import com.scaler.BookMyShowSeptEve.Models.*;
import com.scaler.BookMyShowSeptEve.Repositories.ShowRepository;
import com.scaler.BookMyShowSeptEve.Repositories.ShowSeatRepository;
import com.scaler.BookMyShowSeptEve.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    @Autowired
    UserRepository userRepository;
    ShowRepository showRepository;
    ShowSeatRepository showSeatRepository;


    public Booking bookTicket(Long userId, Long showId, List<Long> showSeatIds) throws InputValidationException {
        // *****Ticket booking logic******
        // 1. Fetch user from userId and check user exists
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isEmpty()){
            throw new InvalidUserException("Invalid user");
        }
        User user = userOptional.get();
        // 2. Fetch show from showId and check show validity
        Optional<Show> showOptional = showRepository.findById(showId);
        if(showOptional.isEmpty()){
            throw new InvalidShowException("Invalid show");
        }
        Show show = showOptional.get();
        // ----------Take lock-----------
        // 3. Fetch all the showSeats from showSeatIds and validate them
        // 4. Loop through all showSeats and check their availability
        // 5. Change the status of the showSeats to blocked
        // ----------Release Lock----------
        List<ShowSeat> showSeats = reserveSeats(showSeatIds, show);

        // 6. Calculate the seat pricing - HW
        Integer totalAmount = 100;

        // 6. Create a booking with the showSeats and other data
        // HW- convert booking class into builder
        Booking booking = new Booking();
        booking.setAmount(totalAmount);
        booking.setShowSeats(showSeats);
        booking.setUser(user);
        booking.setShow(show);
        booking.setBookingStatus(BookingStatus.IN_PROGRESS);

        // 7. Finally return the booking
        return booking;
    }
    @Transactional(isolation = Isolation.SERIALIZABLE)
    private List<ShowSeat> reserveSeats(List<Long> showSeatIds, Show show) throws InputValidationException {
       List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIds);
       List<ShowSeat> validatedShowSeats = showSeats
               .stream()
               .filter((showSeat) -> showSeat.getShow().getId() == show.getId())
               .toList();
       if(validatedShowSeats.isEmpty()){
           // Make it a custom one
           throw new InputValidationException("Invalid seat selection");
       }
       for(ShowSeat showSeat : validatedShowSeats){
           checkAvailability(showSeat);
           showSeat.setStatus(ShowSeatStatus.BLOCKED);
       }
       return showSeatRepository.saveAll(validatedShowSeats);
    }

    private void checkAvailability(ShowSeat showSeat) throws InputValidationException {
        if(showSeat.getStatus().equals(ShowSeatStatus.BOOKED)){
            throw new InputValidationException("Selected seats are booked");
        }
        if(showSeat.getStatus().equals(ShowSeatStatus.BLOCKED)){
            Long timeSinceBlockedInMins = Duration.between(
                    new Date().toInstant(),
                    showSeat.getBlockedAt().toInstant()
            ).toMinutes();

            if(timeSinceBlockedInMins < 5){
                throw new InputValidationException("Selected seats are blocked");
            }
        }
    }

}
//bookTicket(Long userId, Long showId, List<Long> showSeatIds, List<Long> foodItemIds)
// bookTicket(requestDTO)
// if(requestDTO.getFoodItemIds() != null)
// Break till 10:05 PM