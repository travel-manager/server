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


    @Query("SELECT t FROM Transactions t WHERE t.payer = :#{#traveller.id}")
    Transaction getAllTransactionWhoPaid(@Param("traveller") Traveller traveller);
}
