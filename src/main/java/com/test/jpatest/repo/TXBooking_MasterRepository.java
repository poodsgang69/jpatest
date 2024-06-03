package com.test.jpatest.repo;


import com.test.jpatest.model.TXBooking_Master;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TXBooking_MasterRepository extends JpaRepository<TXBooking_Master, Long> {
    //Custom Queries can come here
    @Query("select sum(tbm.bookingNumberOfSeats) as totalSeatsBooked from TXBooking_Master tbm")
    int getTotalNumberOfSeatsBooked();
}
