package com.travelmanager.repositories;


import com.travelmanager.models.Marker;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IMarkerRepository extends PagingAndSortingRepository<Marker, Integer> {
}
