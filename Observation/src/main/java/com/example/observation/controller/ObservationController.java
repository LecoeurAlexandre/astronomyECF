package com.example.observation.controller;

import com.example.observation.dto.ObservationResDTO;
import com.example.observation.dto.ObservationUserDTO;
import com.example.observation.entity.Observation;
import com.example.observation.service.ObservationService;
import com.example.observation.tool.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/observation")
public class ObservationController {
    @Autowired
    private ObservationService _obsService;

    @PostMapping("")
    public ResponseEntity<Observation> post(@RequestParam LocalDate date, @RequestParam String description, @RequestParam String picture, @RequestParam boolean display, @RequestParam int objectId, @RequestParam int userId) {
        Observation observation = _obsService.createObservation(date, description, picture, display, objectId,userId);
        return ResponseEntity.ok(observation);
    }
    @GetMapping("{objectId}")
    public ResponseEntity<ObservationResDTO> getbyCelestObject(@PathVariable int objectId) {
        RestClient<String, String> restClient = new RestClient<>();
        return ResponseEntity.ok(_obsService.getObservationsByObject(objectId));
    }
    @GetMapping("{userId}")
    public ResponseEntity<ObservationUserDTO> getbyUser(@PathVariable int userId) {
        RestClient<String, String> restClient = new RestClient<>();
        return ResponseEntity.ok(_obsService.getObservationsByUser(userId));
    }
    @GetMapping("{date}")
    public ResponseEntity<List<Observation>> getbyDate(@PathVariable LocalDate date) {
        List<Observation> observations = _obsService.getObservationsByDate(date);
        return ResponseEntity.ok(observations);
    }
}
