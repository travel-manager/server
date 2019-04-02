package com.travelmanager.dal.repositories;


import com.travelmanager.domain.models.Trip;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITripRepository extends PagingAndSortingRepository<Trip, Integer> {
}
