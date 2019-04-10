package com.travelmanager.repositories;


import com.travelmanager.models.Notification;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface INotificationRepository extends PagingAndSortingRepository<Notification, Integer> {
}
