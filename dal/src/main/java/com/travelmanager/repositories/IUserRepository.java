package com.travelmanager.repositories;

import com.travelmanager.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface IUserRepository extends PagingAndSortingRepository<User, Integer> {

<<<<<<< HEAD
    @Query("SELECT u FROM User u WHERE u.username = :username")
    User findByUsername(@Param("username") String username);
=======
    @Query("SELECT u FROM user u WHERE u.username = :username")
    User getUserByUsername(@Param("username") String username);
>>>>>>> 25aa2d4346d3cc4ab6053bb7f2befc2bb6afac35
}
