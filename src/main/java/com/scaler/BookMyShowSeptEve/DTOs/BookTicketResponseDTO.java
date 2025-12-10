package com.scaler.BookMyShowSeptEve.DTOs;

import com.scaler.BookMyShowSeptEve.Models.Booking;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookTicketResponseDTO {
//    Long bookingId; // This is the ideal
    Booking booking;
    String message;
    ResponseStatus responseStatus;

}
