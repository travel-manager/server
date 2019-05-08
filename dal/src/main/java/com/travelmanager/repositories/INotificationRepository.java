package com.travelmanager.repositories;


import com.travelmanager.refactoredModels.Notification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface INotificationRepository extends PagingAndSortingRepository<Notification, Integer> {

    @Query(value = "SELECT n from notifications n where n.trip = :trips")
    List<Notification> getAllMarkersByTripId(@Param("trips") int tripId);

    @Query(value = "delete from notifications n where n.trip = :trips")
    void deleteAllMarkersByTripId(@Param("trips") int TripId);
}
