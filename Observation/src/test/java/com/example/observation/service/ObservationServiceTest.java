package com.example.observation.service;

import com.example.observation.dto.CelestObjectDTO;
import com.example.observation.dto.ObservationResDTO;
import com.example.observation.dto.ObservationUserDTO;
import com.example.observation.dto.UserDTO;
import com.example.observation.entity.Observation;
import com.example.observation.repository.ObservationRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
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

    @Test
    public void returnObservationsByDate() {
        LocalDate date = LocalDate.parse("2023-08-17");
        Observation observation = new Observation(1, date, "Jolie étoile filante", "ddd.com", true, 1, 1);
        Mockito.when(observationRepository.findAllByDate(date)).thenReturn(Arrays.asList(observation));
        List<Observation> result = observationService.getObservationsByDate(date);
        Assertions.assertEquals(Arrays.asList(observation), result);
    }
    @Test
    public void returnObservationsByObjectId() {
        LocalDate date = LocalDate.parse("2023-08-17");
        Observation observation = new Observation(1, date, "Jolie étoile filante", "ddd.com", true, 1, 1);
        CelestObjectDTO celestObjectDTO = new CelestObjectDTO(1, "Etoile filante");
        ObservationResDTO obsRes = new ObservationResDTO(Arrays.asList(observation), celestObjectDTO);
        Mockito.when(observationRepository.findAllByObjetId(1)).thenReturn(Arrays.asList(observation));

        ObservationResDTO result = observationService.getObservationsByObject(1);
        Assertions.assertEquals(obsRes, result);
    }
    @Test
    public void returnObservationsByUserId() {
        LocalDate date = LocalDate.parse("2023-08-17");
        Observation observation = new Observation(1, date, "Jolie étoile filante", "ddd.com", true, 1, 1);
        UserDTO userDTO = new UserDTO(1, "Lolo");
        ObservationUserDTO observationUserDTO = new ObservationUserDTO(Arrays.asList(observation), userDTO);
        Mockito.when(observationRepository.findAllByUserId(1)).thenReturn(Arrays.asList(observation));

        ObservationUserDTO result = observationService.getObservationsByUser(1);
        Assertions.assertEquals(observationUserDTO, result);
    }

}
