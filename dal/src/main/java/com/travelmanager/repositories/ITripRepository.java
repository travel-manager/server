package com.travelmanager.repositories;


import com.travelmanager.models.Trip;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface ITripRepository extends PagingAndSortingRepository<Trip, Integer> {


    @Query("SELECT t from trips t WHERE t.datestart = :dateBegin AND t.dateend = :dateEnd")
    List<Trip> getAllBetweenDates(@Param("dateBegin") Date dateBegin, @Param("dateEnd") Date dateEnd);

    @Query("SELECT t from trips t WHERE t.location.latitude BETWEEN :latMinus AND :latPlus AND t.location.longtitude BETWEEN :longMinus AND :longPlus")
    List<Trip> getAllBetweenLatAndLongWithRange(@Param("latMinus") Float latMinus, @Param("latPlus") Float latPlus, @Param("longMinus") Float longMinus, @Param("longPlus") Float longPlus);

    @Query("SELECT t from trips t WHERE t.location.latitude = :lat AND t.location.longtitude = :longitude")
    List<Trip> getAllBetweenLatAndLong(@Param("lat") Float lat, @Param("longitude") Float longitude);
}
