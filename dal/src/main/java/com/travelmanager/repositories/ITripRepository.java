package com.travelmanager.repositories;


import com.travelmanager.models.Trip;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITripRepository extends PagingAndSortingRepository<Trip, Integer> {
}
