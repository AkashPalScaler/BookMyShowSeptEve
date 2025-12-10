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
    private ShowSeatStatus status;
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

    public ShowSeatStatus getStatus() {
        return status;
    }

    public void setStatus(ShowSeatStatus status) {
        this.status = status;
        if(status.equals(ShowSeatStatus.BLOCKED)){
            setBlockedAt(new Date());
        }
    }
}


// Show seat represents virtual seat you are booking, but 1 physical can be in many shows
// ShowSeat : Seat
// 11AM_H1  :  H1
// 11AM_H2  :  H2
// 12AM_H1  :  H1
// 12AM_H2  :  H2

