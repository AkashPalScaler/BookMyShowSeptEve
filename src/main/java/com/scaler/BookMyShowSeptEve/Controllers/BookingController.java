package com.scaler.BookMyShowSeptEve.Controllers;

import com.scaler.BookMyShowSeptEve.DTOs.BookTicketRequestDTO;
import com.scaler.BookMyShowSeptEve.DTOs.BookTicketResponseDTO;
import com.scaler.BookMyShowSeptEve.DTOs.ResponseStatus;
import com.scaler.BookMyShowSeptEve.Exceptions.InputValidationException;
import com.scaler.BookMyShowSeptEve.Models.Booking;
import com.scaler.BookMyShowSeptEve.Services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController {
    @Autowired
    BookingService bookingService;
    BookTicketResponseDTO bookTicket(BookTicketRequestDTO requestDTO){
        BookTicketResponseDTO responseDTO = new BookTicketResponseDTO();
        try{
            // analyse(requestDto.getCookieDaTA)
            // In case too many fields to pass to service - requestDTo(12 props) -> bookTicketServiceDTO(10)
            Booking booking = bookingService.bookTicket(requestDTO.getUserId(),
                    requestDTO.getShowId(), requestDTO.getShowSeatIds());
            responseDTO.setBooking(booking);
            responseDTO.setMessage("Booking Successfull");
            responseDTO.setResponseStatus(ResponseStatus.SUCCESS);
        }
        catch (InputValidationException e) {
            System.out.println("[BookingController.bookTicket] Booking inputs failed the validation: " + e.getMessage());
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
            responseDTO.setMessage("Input validation failed for reason : " + e.getMessage());
        }
        catch (Exception e){
            System.out.println("[BookingController.bookTicket] Failure in booking : " + e.getMessage());
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
            responseDTO.setMessage("Booking failed");
        }
        return responseDTO;
    }
}
