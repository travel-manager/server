package com.travelmanager.dal.repositories;

import com.travelmanager.domain.models.Traveller;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ITravellerRepository extends PagingAndSortingRepository<Traveller, Integer> {
}
