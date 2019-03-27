package com.travelmanager.dal.repositories;


import com.travelmanager.domain.models.Location;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ILocationRepository extends PagingAndSortingRepository<Location, Integer> {
}
