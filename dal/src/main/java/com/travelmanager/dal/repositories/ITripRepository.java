package com.travelmanager.dal.repositories;


import com.travelmanager.domain.models.Trip;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ITripRepository extends PagingAndSortingRepository<Trip, Integer> {
}
