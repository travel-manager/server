package com.travelmanager.repositories;

import com.travelmanager.models.Transaction;
import com.travelmanager.models.Traveller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITransactionRepository extends JpaRepository<Transaction, Integer> {

    @Query()
    List<Transaction> getAllTransactionWhoPaid(Traveller traveller);
}
