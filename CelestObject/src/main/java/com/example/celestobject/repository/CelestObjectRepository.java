package com.example.celestobject.repository;

import com.example.celestobject.entity.CelestObject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CelestObjectRepository extends CrudRepository<CelestObject, Integer> {
}
