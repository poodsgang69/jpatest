package com.test.jpatest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
//Might need named query here
public class TXBooking_Master {

    @Id
    @GeneratedValue
    private Long bookingId;
    private String bookingName;
    private Integer bookingNumberOfSeats;

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public String getBookingName() {
        return bookingName;
    }

    public void setBookingName(String bookingName) {
        this.bookingName = bookingName;
    }

    public Integer getBookingNumberOfSeats() {
        return bookingNumberOfSeats;
    }

    public void setBookingNumberOfSeats(Integer bookingNumberOfSeats) {
        this.bookingNumberOfSeats = bookingNumberOfSeats;
    }
}
