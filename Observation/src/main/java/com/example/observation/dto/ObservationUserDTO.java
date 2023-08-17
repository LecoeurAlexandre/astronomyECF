package com.example.observation.dto;

import com.example.observation.entity.Observation;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ObservationUserDTO {
    private List<Observation> obs;
    private UserDTO userDTO;
}
