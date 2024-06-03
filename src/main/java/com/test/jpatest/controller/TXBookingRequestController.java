package com.test.jpatest.controller;

import com.test.jpatest.model.TXBooking_Master;
import com.test.jpatest.model.TXBooking_MasterResponse;
import com.test.jpatest.repo.TXBooking_MasterRepository;
import com.test.jpatest.serivce.TXHandleBookingService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class TXBookingRequestController {

    private static Integer currentNumberOfSeatsBooked = 0;

    private static final Integer totalNumberOfSeats = 200;

    @Autowired
    private TXBooking_MasterRepository txBookingMasterRepository;

    @Autowired
    private TXHandleBookingService txHandleBookingService;

    @PostMapping("newBooking")
    public ResponseEntity<TXBooking_MasterResponse> createBooking (@Valid @RequestBody TXBooking_Master newBooking) {
        Integer seatsBooked = newBooking.getBookingNumberOfSeats();
        int totalNumberOfSeatsBooked = txBookingMasterRepository.getTotalNumberOfSeatsBooked();
        if (seatsBooked > 100) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    TXBooking_MasterResponse.builder()
                            .bookingId(newBooking.getBookingId())
                            .bookingName(newBooking.getBookingName())
                            .bookingNumberOfSeats(newBooking.getBookingNumberOfSeats())
                            .message("Cannot book seats more than 100!")
                    .build()
            );
        } else if (seatsBooked + totalNumberOfSeatsBooked > totalNumberOfSeats) {
            Integer remainingSeats = Math.abs(totalNumberOfSeats - totalNumberOfSeatsBooked);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    TXBooking_MasterResponse.builder()
                            .bookingId(newBooking.getBookingId())
                            .bookingName(newBooking.getBookingName())
                            .bookingNumberOfSeats(newBooking.getBookingNumberOfSeats())
                            .message("There are no more seats remaining! Only " + remainingSeats + " are left.")
                            .build()
            );
        }
        currentNumberOfSeatsBooked += seatsBooked;
        //otherwise
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(txHandleBookingService.postBookingHandlerService(newBooking));
    }


    @GetMapping("allBookings")
    public List<TXBooking_Master> getAllBookingDetails () {
        return txHandleBookingService.getAllBookingsHandler();
    }

    @GetMapping("currentSeatsBooked")
    public int currentSeatsBooked () {
        return txBookingMasterRepository.getTotalNumberOfSeatsBooked();
    }

    @DeleteMapping("deleteBooking/{bookingId}")
    public ResponseEntity<TXBooking_MasterResponse> deleteBooking (@Valid @PathVariable Long bookingId) {

        return ResponseEntity.status(HttpStatus.OK).body(txHandleBookingService.deleteBookingHandlerService(bookingId));

    }

    @PutMapping("updateBooking/{bookingId}")
    public ResponseEntity<TXBooking_MasterResponse> updateBooking (@Valid @RequestBody TXBooking_Master updatedUser, @PathVariable Long bookingId) {
        return ResponseEntity.status(HttpStatus.OK).body(txHandleBookingService.updateBookingHandler(updatedUser, bookingId, totalNumberOfSeats));
    }

}
