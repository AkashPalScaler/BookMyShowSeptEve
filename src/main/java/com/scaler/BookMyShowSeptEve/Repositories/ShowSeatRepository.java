package com.scaler.BookMyShowSeptEve.Repositories;

import com.scaler.BookMyShowSeptEve.Models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {
}
