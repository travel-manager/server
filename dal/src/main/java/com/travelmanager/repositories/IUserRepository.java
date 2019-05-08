package com.travelmanager.repositories;

import com.travelmanager.refactoredModels.Transaction;
import com.travelmanager.refactoredModels.Traveller;
import com.travelmanager.refactoredModels.Trip;
import com.travelmanager.refactoredModels.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface IUserRepository extends PagingAndSortingRepository<User, Integer> {

    @Query("SELECT u FROM User u WHERE u.username = :username")
    User getUserByUsername(@Param("username") String username);
}
