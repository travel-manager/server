package com.travelmanager.dal.repositories;

import com.travelmanager.domain.models.Transaction;
import com.travelmanager.domain.models.Traveller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ITransactionRepository extends JpaRepository<Transaction, Integer> {

    @Query()
    List<Transaction> getAllTransactionWhoPaid(Traveller traveller);
}