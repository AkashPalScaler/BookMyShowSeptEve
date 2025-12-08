package com.scaler.BookMyShowSeptEve;

import com.scaler.BookMyShowSeptEve.Controllers.UserController;
import com.scaler.BookMyShowSeptEve.DTOs.UserSignupRequestDTO;
import com.scaler.BookMyShowSeptEve.DTOs.UserSignupResponseDTO;
import com.scaler.BookMyShowSeptEve.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookMyShowSeptEveApplication implements CommandLineRunner {
	@Autowired
	UserController userController;
	public static void main(String[] args) {
		SpringApplication.run(BookMyShowSeptEveApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		UserSignupRequestDTO signUpRequestDTO = new UserSignupRequestDTO();
		signUpRequestDTO.setName("Akash Pal");
		signUpRequestDTO.setEmail("akash.pal2@gmail.com");
		signUpRequestDTO.setPassword("passpass");

		UserSignupResponseDTO signUpResponseDTO = userController.signup(signUpRequestDTO);

		System.out.println(signUpResponseDTO.getMessage());
	}
}

// User Signup: (UserSignupRequestDTO, UserSignupResponseDTO)UserController -> UserService