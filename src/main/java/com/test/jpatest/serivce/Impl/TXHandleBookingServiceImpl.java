package com.test.jpatest.serivce.Impl;

import com.test.jpatest.controller.TXBookingRequestController;
import com.test.jpatest.model.TXBooking_Master;
import com.test.jpatest.model.TXBooking_MasterResponse;
import com.test.jpatest.repo.TXBooking_MasterRepository;
import com.test.jpatest.serivce.TXHandleBookingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class TXHandleBookingServiceImpl implements TXHandleBookingService {

    @Autowired
    private TXBooking_MasterRepository txBookingMasterRepository;

    @Override
    public TXBooking_MasterResponse postBookingHandlerService (TXBooking_Master newBooking) {
        txBookingMasterRepository.save(newBooking);
        return TXBooking_MasterResponse.builder()
                .bookingId(newBooking.getBookingId())
                .bookingName(newBooking.getBookingName())
                .bookingNumberOfSeats(newBooking.getBookingNumberOfSeats())
                .message("Successfully Submitted Booking!")
                .build();
    }

    @Override
    public List<TXBooking_Master> getAllBookingsHandler () {
        return txBookingMasterRepository.findAll();
    }

    @Override
    public TXBooking_MasterResponse deleteBookingHandlerService (Long bookingId) {
        if(!txBookingMasterRepository.existsById(bookingId)) {
            return TXBooking_MasterResponse.builder()
                    .bookingId(null)
                    .bookingName(null)
                    .bookingNumberOfSeats(null)
                    .message("There is no booking with id: " + bookingId)
                    .build();
        }

        TXBooking_MasterResponse deletedBooking = TXBooking_MasterResponse.builder()
                .bookingId(txBookingMasterRepository.findById(bookingId).get().getBookingId())
                .bookingName(txBookingMasterRepository.findById(bookingId).get().getBookingName())
                .bookingNumberOfSeats(txBookingMasterRepository.findById(bookingId).get().getBookingNumberOfSeats())
                .message("This booking has been successfully deleted.")
                .build();

        txBookingMasterRepository.deleteById(bookingId);

        return deletedBooking;
    }

    @Override
    public TXBooking_MasterResponse updateBookingHandler (TXBooking_Master updatedUser,
                                                          Long bookingId,
                                                          Integer totalNumberOfSeats) {
//        if(!txBookingMasterRepository.existsById(bookingId)) {
//            return TXBooking_MasterResponse.builder()
//                    .bookingId(null)
//                    .bookingName(null)
//                    .bookingNumberOfSeats(null)
//                    .message("There is no booking with id: " + bookingId)
//                    .build();
//        }

//        txBookingMasterRepository.findById(bookingId)
//                .map(booking -> {
//                    booking.setBookingId(updatedUser.getBookingId());
//                    booking.setBookingName(updatedUser.getBookingName());
//                    booking.setBookingNumberOfSeats(updatedUser.getBookingNumberOfSeats());
//                    return txBookingMasterRepository.save(booking);
//                }).orElse(
//                        () -> {
//                            return TXBooking_MasterResponse.builder()
//                                    .bookingId(null)
//                                    .bookingName(null)
//                                    .bookingNumberOfSeats(null)
//                                    .message("There is no booking with id: " + bookingId)
//                                    .build();
//                        }
//                );
        //validate whether the updates make the maxSeats greater than the set values
        Integer totalNumberOfSeatsBooked = txBookingMasterRepository.getTotalNumberOfSeatsBooked();
        if ((totalNumberOfSeatsBooked - txBookingMasterRepository
                        .findById(bookingId)
                        .get()
                        .getBookingNumberOfSeats()) + updatedUser.getBookingNumberOfSeats() > totalNumberOfSeats) {
            Integer remainingSeats = Math.abs(totalNumberOfSeats - totalNumberOfSeatsBooked);
            return TXBooking_MasterResponse.builder()
                    .bookingId(updatedUser.getBookingId())
                    .bookingName(updatedUser.getBookingName())
                    .bookingNumberOfSeats(updatedUser.getBookingNumberOfSeats())
                    .message("There are no more seats remaining! Only " + remainingSeats + " are left.")
                    .build();
        }

        return txBookingMasterRepository.findById(bookingId)
                .map(booking -> {
                    booking.setBookingId(updatedUser.getBookingId());
                    booking.setBookingName(updatedUser.getBookingName());
                    booking.setBookingNumberOfSeats(updatedUser.getBookingNumberOfSeats());
                    txBookingMasterRepository.save(booking);
                    return TXBooking_MasterResponse.builder()
                            .bookingId(updatedUser.getBookingId())
                            .bookingName(updatedUser.getBookingName())
                            .bookingNumberOfSeats(updatedUser.getBookingNumberOfSeats())
                            .message("Booking with the id has been updated.")
                            .build();
                })
                .orElseGet(() -> {
                    return TXBooking_MasterResponse.builder()
                                    .bookingId(null)
                                    .bookingName(null)
                                    .bookingNumberOfSeats(null)
                                    .message("There is no booking with id: " + bookingId)
                                    .build();
                });
    }
}
