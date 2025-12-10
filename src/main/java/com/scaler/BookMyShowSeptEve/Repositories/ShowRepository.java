package com.scaler.BookMyShowSeptEve.Repositories;

import com.scaler.BookMyShowSeptEve.Models.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {
}
