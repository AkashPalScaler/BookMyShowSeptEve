package com.scaler.BookMyShowSeptEve.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSignupRequestDTO {
    String name;
    String email;
    String password;
}
