package com.travelmanager.dal.repositories;

import com.travelmanager.domain.models.Chat;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IChatRepository extends PagingAndSortingRepository<Chat, Integer> {
}
