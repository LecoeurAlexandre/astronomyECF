package com.example.observation.repository;

import com.example.observation.entity.Observation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface ObservationRepository extends CrudRepository<Observation, Integer> {
    List<Observation> findAllByObjetId(int objectId);
    List<Observation> findAllByDate(LocalDate date);
    List<Observation> findAllByUserId(int userId);

}
