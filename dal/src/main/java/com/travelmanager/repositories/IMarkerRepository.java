package com.travelmanager.repositories;


import com.travelmanager.refactoredModels.Marker;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMarkerRepository extends PagingAndSortingRepository<Marker, Integer> {

    @Query(value = "SELECT m from markers m where m.trip = :trips")
    List<Marker> getAllMarkersByTripId(@Param("trips") int tripId);

    @Query(value = "delete from markers m where m.trip = :trips")
    void deleteAllMarkersByTripId(@Param("trips") int TripId);
}
