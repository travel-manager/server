package com.travelmanager.dal.repositories;


import com.travelmanager.domain.models.Notification;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface INotificationRepository extends PagingAndSortingRepository<Notification, Integer> {
}
