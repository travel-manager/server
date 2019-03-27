package com.travelmanager.dal.repositories;


import com.travelmanager.domain.models.Marker;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IMarkerRepository extends PagingAndSortingRepository<Marker, Integer> {
}
