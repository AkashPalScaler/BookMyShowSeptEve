package com.scaler.BookMyShowSeptEve.Controllers;

import com.scaler.BookMyShowSeptEve.DTOs.ResponseStatus;
import com.scaler.BookMyShowSeptEve.DTOs.UserSignupRequestDTO;
import com.scaler.BookMyShowSeptEve.DTOs.UserSignupResponseDTO;
import com.scaler.BookMyShowSeptEve.Models.User;
import com.scaler.BookMyShowSeptEve.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    public UserSignupResponseDTO signup(UserSignupRequestDTO requestDTO){
        UserSignupResponseDTO responseDTO = new UserSignupResponseDTO();
        try{
            User user = userService.signup(requestDTO.getName(),
                    requestDTO.getEmail(), requestDTO.getPassword());
            responseDTO.setUser(user);
            responseDTO.setMessage("User signup is successfull");
            responseDTO.setResponseStatus(ResponseStatus.SUCCESS);


        }catch(Exception e){
            System.out.println("[UserController.signup] User Signup :" + e.getMessage());
            responseDTO.setMessage("User signup failed");
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
        }
        return  responseDTO;
    }
}

// Registry { "UserController" -> userControllerObject,"UserService" -> userServiceObject }
// Break till 10:19 PM