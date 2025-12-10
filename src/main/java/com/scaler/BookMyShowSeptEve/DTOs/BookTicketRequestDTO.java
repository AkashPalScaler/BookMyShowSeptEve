package com.scaler.BookMyShowSeptEve.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookTicketRequestDTO {
    Long userId;
    Long showId;
    List<Long> showSeatIds;
}
