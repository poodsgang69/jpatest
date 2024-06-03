package com.test.jpatest.serivce;

import com.test.jpatest.model.TXBooking_Master;
import com.test.jpatest.model.TXBooking_MasterResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface TXHandleBookingService {
    TXBooking_MasterResponse postBookingHandlerService (TXBooking_Master newBooking);

    List<TXBooking_Master> getAllBookingsHandler ();

    TXBooking_MasterResponse deleteBookingHandlerService (Long bookingId);

    TXBooking_MasterResponse updateBookingHandler (TXBooking_Master updatedUser,
                                                   Long bookingId,
                                                   Integer totalNumberOfSeats);
}
