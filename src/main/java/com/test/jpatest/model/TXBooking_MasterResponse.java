package com.test.jpatest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TXBooking_MasterResponse {
    @Id
    private Long bookingId;
    private String bookingName;
    private Integer bookingNumberOfSeats;
    private String message;

}
