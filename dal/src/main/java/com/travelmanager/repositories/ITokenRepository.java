package com.travelmanager.repositories;

import com.travelmanager.refactoredModels.Token;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITokenRepository extends PagingAndSortingRepository<Token, Integer> {
    Token findByToken(String token);
}
