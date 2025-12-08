package com.scaler.BookMyShowSeptEve.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Booking extends BaseModel{
    // Booking 1:M Payments
    @OneToMany(mappedBy = "booking")
    private List<Payment> payments; // a new mapping table for it
    private int amount;
    @ManyToOne
    private User user;
    // Booking M:1 Show
    @ManyToOne
    private Show show;
    // Booking 1:M showSeats
    @OneToMany
    private List<ShowSeat> showSeats; // The seats of one/that show
    @Enumerated(EnumType.ORDINAL)
    private BookingStatus bookingStatus;

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public List<ShowSeat> getShowSeats() {
        return showSeats;
    }

    public void setShowSeats(List<ShowSeat> showSeats) {
        this.showSeats = showSeats;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }
}

// bookingStatus : id | value -> Springboot doesn't by default create this(enum) table
// booking : id | amount | user_id | show_id | booking_status
// Enumtype:STRING  1 | 1239  | 98123624 | 12 |  IN_PROGRESS
// Enumtype:ORDINAL 1 | 1239  | 98123624 | 12 |  0

// Booking b = //ORM
// b.bookingStatus
