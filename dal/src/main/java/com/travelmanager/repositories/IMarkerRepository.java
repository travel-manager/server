package com.travelmanager.repositories;


import com.travelmanager.models.Marker;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMarkerRepository extends PagingAndSortingRepository<Marker, Integer> {
}
