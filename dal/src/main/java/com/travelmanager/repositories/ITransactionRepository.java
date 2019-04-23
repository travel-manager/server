package com.travelmanager.repositories;

import com.travelmanager.models.Transaction;
import com.travelmanager.models.Traveller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITransactionRepository extends PagingAndSortingRepository<Transaction, Integer> {


    @Query("SELECT t FROM transactions t WHERE t.payer = :#{#traveller.id}")
    Transaction getAllTransactionWhoPaid(@Param("traveller") Traveller traveller);


    @Query("SELECT t from transactions t WHERE t.payer = :payer AND t.trip = :trip")
    List<Transaction> getAllByPayerAndTripId(@Param("payer") int payer,@Param("trip") int tripId);

    @Query("SELECT t FROM transactions t WHERE t.freeloaders = :freeloaders AND t.trip = :trip")
    List<Transaction> getAllByFreeLoaderAndTripId(@Param("freeloaders") String freeLoader,@Param("trip") int tripId);

}
