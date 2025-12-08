package com.scaler.BookMyShowSeptEve.Repositories;

import com.scaler.BookMyShowSeptEve.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Explore more on the naming conventions
    Optional<User> findByEmail(String email);
}
