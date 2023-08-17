package com.example.observation.service;

import com.example.observation.dto.CelestObjectDTO;
import com.example.observation.dto.ObservationResDTO;
import com.example.observation.dto.ObservationUserDTO;
import com.example.observation.dto.UserDTO;
import com.example.observation.entity.Observation;
import com.example.observation.repository.ObservationRepository;
import com.example.observation.tool.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ObservationService {
    @Autowired
    private ObservationRepository _obsRepo;

    public Observation createObservation(LocalDate date, String description, String picture, Boolean display, int objectId, int userId) {
        Observation observation = Observation.builder().date(date).description(description).picture(picture).display(display).objetId(objectId).userId(userId).build();
        _obsRepo.save(observation);
        return observation;
    }
    public List<Observation> getObservationsByDate(LocalDate date) {
        return _obsRepo.findAllByDate(date);
    }
    public ObservationUserDTO getObservationsByUser(int userId) {
        RestClient<UserDTO, String> restClient = new RestClient<>();
        ObservationUserDTO observationUserDTO = ObservationUserDTO.builder()
                .obs(_obsRepo.findAllByUserId(userId))
                .userDTO(restClient.getUser("user/"+userId, UserDTO.class))
                .build();
        return observationUserDTO;
    }
    public ObservationResDTO getObservationsByObject(int objectId) {
        RestClient<CelestObjectDTO, String> restClient = new RestClient<>();
        ObservationResDTO observationResDTO = ObservationResDTO.builder()
                .obs(_obsRepo.findAllByObjetId(objectId))
                .celestObjectDTO(restClient.getCelestObject("co/"+objectId, CelestObjectDTO.class))
                .build();
        return observationResDTO;
    }
}
