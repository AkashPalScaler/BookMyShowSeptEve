package com.scaler.BookMyShowSeptEve.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class ShowSeat extends BaseModel {
    // ShowSeat : Show
    @ManyToOne
    private Show show;
    // ShowSeat M:1 Seat
    @ManyToOne
    private  Seat seat; // seatType
    @Enumerated(EnumType.ORDINAL)
    private SeatStatus seatStatus;
    private Date blockedAt;

    public Date getBlockedAt() {
        return blockedAt;
    }

    public void setBlockedAt(Date blockedAt) {
        this.blockedAt = blockedAt;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public SeatStatus getSeatStatus() {
        return seatStatus;
    }

    public void setSeatStatus(SeatStatus seatStatus) {
        this.seatStatus = seatStatus;
    }
}


// Show seat represents virtual seat you are booking, but 1 physical can be in many shows
// ShowSeat : Seat
// 11AM_H1  :  H1
// 11AM_H2  :  H2
// 12AM_H1  :  H1
// 12AM_H2  :  H2

