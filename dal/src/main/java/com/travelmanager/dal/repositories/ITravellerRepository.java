package com.travelmanager.dal.repositories;

import com.travelmanager.models.Traveller;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ITravellerRepository extends PagingAndSortingRepository<Traveller, Integer> {
}
