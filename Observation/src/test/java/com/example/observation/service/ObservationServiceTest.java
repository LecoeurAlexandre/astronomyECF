package com.example.observation.service;

import com.example.observation.entity.Observation;
import com.example.observation.repository.ObservationRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.time.LocalDate;

public class ObservationServiceTest {
    @Mock
    private ObservationRepository observationRepository;
    @InjectMocks
    private ObservationService observationService;
    @Test
    public void addNewObservationwithValidData() {
        LocalDate localDate = LocalDate.parse("2023-08-17");
        Observation observation = new Observation(localDate, "Jolie étoile filante", "ddd.com", true, 1, 1);
        Mockito.when(observationRepository.save(observation)).thenReturn(observation);

        Observation obsResult = observationService.createObservation(localDate, "Jolie étoile filante", "ddd.com", true, 1, 1);
    }
}
