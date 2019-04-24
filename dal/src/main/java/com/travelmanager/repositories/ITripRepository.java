package com.travelmanager.repositories;


import com.travelmanager.models.Transaction;
import com.travelmanager.models.Trip;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface ITripRepository extends PagingAndSortingRepository<Trip, Integer> {


    @Query("SELECT t from Trips t WHERE t.datestart = :dateBegin AND t.dateend = :dateEnd")
    List<Trip> getAllBetweenDates(@Param("dateBegin") Date dateBegin, @Param("dateEnd") Date dateEnd);

    @Query("SELECT t from Trips t WHERE t.latitude BETWEEN :latMinus AND :latPlus AND t.longtitude BETWEEN :longMinus AND :longPlus")
    List<Trip> getAllBetweenLatAndLongWithRange(@Param("latMinus") Float latMinus, @Param("latPlus") Float latPlus, @Param("longMinus") Float longMinus, @Param("longPlus") Float longPlus);

    @Query("SELECT t from Trips t WHERE t.latitude = :lat AND t.longtitude = :longitude")
    List<Trip> getAllBetweenLatAndLong(@Param("lat") Float lat, @Param("longitude") Float longitude);
}
