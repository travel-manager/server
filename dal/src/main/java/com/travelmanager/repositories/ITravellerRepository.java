package com.travelmanager.repositories;

import com.travelmanager.models.Traveller;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ITravellerRepository extends PagingAndSortingRepository<Traveller, Integer> {

    @Query("SELECT u FROM Travellers u WHERE u.username = :username")
    Traveller getTravellerByUsername(@Param("username") String username);
}
