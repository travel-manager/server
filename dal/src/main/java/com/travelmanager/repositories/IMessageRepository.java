package com.travelmanager.repositories;

import com.travelmanager.models.Message;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IMessageRepository extends PagingAndSortingRepository<Message, Integer> {
}
