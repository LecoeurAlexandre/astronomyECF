package com.example.observation.dto;

import com.example.observation.entity.Observation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class ObservationUserDTO {
    private List<Observation> obs;
    private UserDTO userDTO;
}
