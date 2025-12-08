package com.scaler.BookMyShowSeptEve.DTOs;

import com.scaler.BookMyShowSeptEve.Models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSignupResponseDTO {
    User user; // user_id
    String message;
    ResponseStatus responseStatus;
}
