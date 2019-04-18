package com.travelmanager.repositories;

import com.travelmanager.models.WebsocketMessage;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IMessageRepository extends PagingAndSortingRepository<WebsocketMessage, Integer> {
}
