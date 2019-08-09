package com.adidas.challenge.datasubs.repositories;

import com.adidas.challenge.datasubs.domain.Subs;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubsDataRepository extends CrudRepository<Subs, Integer> {
}
