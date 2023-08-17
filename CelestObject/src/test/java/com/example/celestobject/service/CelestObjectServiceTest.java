package com.example.celestobject.service;

import com.example.celestobject.entity.CelestObject;
import com.example.celestobject.repository.CelestObjectRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

public class CelestObjectServiceTest {
    @Mock
    private CelestObjectRepository celestObjectRepository;
    @InjectMocks
    private CelestObjectService celestObjectService;
    @Test
    public void shouldAddNewCelestObjWithValidData() {
        CelestObject celestObject = new CelestObject("Lune");
        Mockito.when(celestObjectRepository.save(celestObject)).thenReturn(celestObject);

        CelestObject result = celestObjectService.createCelestObj("Lune");

        Assertions.assertEquals(celestObject, result);
    }
}
