package com.travelmanager.repositories;

import com.travelmanager.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends PagingAndSortingRepository<User, Integer> {

    @Query("SELECT u FROM user u WHERE u.username = :username")
    User findByUsername(@Param("username") String username);
}
