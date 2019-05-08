package com.travelmanager.repositories;

import com.travelmanager.refactoredModels.Message;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IMessageRepository extends PagingAndSortingRepository<Message, Integer> {
}
