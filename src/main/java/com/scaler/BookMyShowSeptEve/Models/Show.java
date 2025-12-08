package com.scaler.BookMyShowSeptEve.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity(name="bms_show")
public class Show extends BaseModel {
    private Date start_time;
    // Show M:1 Movie
    @ManyToOne
    private Movie movie;
    // Show M:1 Theatre
    @ManyToOne
    private Theatre theatre;
    // Show M:1 Screen
    @ManyToOne
    private Screen screen;
    // Show 1:M showSeat
    @OneToMany
    private List<ShowSeat> showSeatList;
    // SHow 1:M showSeatType
    @OneToMany
    private List<ShowSeatType> showSeatTypeList;

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public List<ShowSeat> getShowSeatList() {
        return showSeatList;
    }

    public void setShowSeatList(List<ShowSeat> showSeatList) {
        this.showSeatList = showSeatList;
    }

    public List<ShowSeatType> getShowSeatTypeList() {
        return showSeatTypeList;
    }

    public void setShowSeatTypeList(List<ShowSeatType> showSeatTypeList) {
        this.showSeatTypeList = showSeatTypeList;
    }
}


// Show ShowSeat
// 11AM  11AM_H1 - Booked
// 11AM  11AM_H2 - Not Booked
// 11AM  11AM_J1
// 11AM  11AM_J2
// 12AM  12AM_H1
// 12AM  12AM_H2

// Show ShowSeatType
// 11AM   11AM_GOLD - 500
// 11AM   11AM_SILVER -200
// 12PM   12PM_GOLD - 1200
// 12PM   12PM_SILVER - 700
